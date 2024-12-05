package com.example.jooqtest.film

import com.example.jooqtest.config.PriceCategoryConverter
import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.DatePart.*
import org.jooq.generated.tables.JFilm
import org.jooq.generated.tables.daos.FilmDao
import org.jooq.generated.tables.pojos.Film
import org.jooq.generated.tables.references.INVENTORY
import org.jooq.generated.tables.references.RENTAL
import org.jooq.impl.DSL
import org.jooq.impl.DSL.*
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
class FilmRepositoryHasA(
    private val dslContext: DSLContext,
    configuration: Configuration
) {

    private val dao = FilmDao(configuration)
    private val FILM = JFilm.FILM

    fun findByRangeBetween(start: Int, end: Int): List<Film> {
        return dao.fetchRangeOfJLength(start, end)
    }

    fun findFilmPriceSummeryByFilmTitle(filmTitle: String): List<FilmPriceSummery> {
        return dslContext.select(
            FILM.FILM_ID,
            FILM.TITLE,
            FILM.RENTAL_RATE,
            case_().`when`(FILM.RENTAL_RATE.le(BigDecimal.valueOf(1.0)), "Cheap")
                .`when`(FILM.RENTAL_RATE.le(BigDecimal.valueOf(3.0)), "Moderate")
                .else_("Expensive").`as`("price_category").convert(PriceCategoryConverter()),
            selectCount().from(INVENTORY).where(INVENTORY.FILM_ID.eq(FILM.FILM_ID))
                .asField<Long>("total_inventory")
        ).from(FILM)
            .where(FILM.TITLE.like("%${filmTitle}%"))
            .fetchInto(FilmPriceSummery::class.java)
    }

    fun findFilmRentalSummeryByFilmTitle(filmTitle: String): List<FilmRentalSummery> {

        var rentalDurationInfoSubquery = select(
            INVENTORY.FILM_ID,
            avg(
                localDateTimeDiff(
                    DAY,
                    RENTAL.RENTAL_DATE,
                    RENTAL.RETURN_DATE
                )
            ).`as`("average_rental_duration")
        ).from(RENTAL).join(INVENTORY).on(RENTAL.INVENTORY_ID.eq(INVENTORY.INVENTORY_ID))
            .where(RENTAL.RETURN_DATE.isNotNull)
            .groupBy(INVENTORY.FILM_ID).asTable("rental_duration_info")

        return dslContext.select(
            FILM.FILM_ID,
            FILM.TITLE,
            rentalDurationInfoSubquery.field("average_rental_duration")
        ).from(FILM)
            .join(rentalDurationInfoSubquery)
            .on(FILM.FILM_ID.eq(rentalDurationInfoSubquery.field(INVENTORY.FILM_ID)))
            .where(FILM.TITLE.like("%${filmTitle}%"))
            .orderBy(field(name("average_rental_duration")).desc())
            .fetchInto(FilmRentalSummery::class.java)

    }

    fun findRentedFilmByTitle(filmTitle: String): List<Film> {
        return dslContext.selectFrom(FILM)
            .where(
                exists(
                    selectOne().from(INVENTORY)
                        .join(RENTAL)
                        .on(RENTAL.INVENTORY_ID.eq(INVENTORY.INVENTORY_ID))
                        .where(INVENTORY.FILM_ID.eq(FILM.FILM_ID))
                ),
                FILM.TITLE.like("%${filmTitle}%")
            ).fetchInto(Film::class.java)
    }


}