package com.example.jooqtest.film

import org.jooq.generated.tables.pojos.Category
import org.jooq.generated.tables.pojos.Film
import org.jooq.generated.tables.pojos.FilmCategory
import java.time.LocalDateTime

data class FilmWithCategory(
    private val film: Film? = null,
    private val filmCategory: FilmCategory? = null,
    private val category: Category? = null
) {

    val filmId: Long?
        get() = this.film?.filmId

    val categoryName: String?
        get() = this.category?.name

    val categoryLastUpdate: LocalDateTime?
        get() = this.category?.lastUpdate
}
