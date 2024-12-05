package com.example.jooqtest.actor

import com.example.jooqtest.utils.jooq.JooqListConditionUtil.inIfNotEmpty
import org.jooq.Condition
import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.Field
import org.jooq.generated.tables.JActor
import org.jooq.generated.tables.JFilm
import org.jooq.generated.tables.JFilmActor
import org.jooq.generated.tables.daos.ActorDao
import org.jooq.generated.tables.pojos.Actor
import org.jooq.generated.tables.pojos.Film
import org.jooq.generated.tables.records.ActorRecord
import org.jooq.generated.tables.references.FILM
import org.jooq.generated.tables.references.FILM_ACTOR
import org.jooq.impl.DSL
import org.jooq.impl.DSL.noCondition
import org.jooq.impl.DSL.row
import org.springframework.stereotype.Repository

@Repository
class ActorRepository(
    private val dslContext: DSLContext,
    configuration: Configuration
) {

    private val ACTOR: JActor = JActor.ACTOR
    private val actorDao: ActorDao = ActorDao(configuration)

    fun findByFistNameAndLastName(firstName: String, lastName: String): List<Actor> {
        return dslContext.selectFrom(ACTOR)
            .where(
                ACTOR.FIRST_NAME.eq(firstName),
                ACTOR.LAST_NAME.eq(lastName)
            ).fetchInto(Actor::class.java)
    }

    fun findByFistNameOrLastName(firstName: String, lastName: String): List<Actor> {
        return dslContext.selectFrom(ACTOR)
            .where(
                ACTOR.FIRST_NAME.eq(firstName)
                    .or(ACTOR.LAST_NAME.eq(lastName))
            ).fetchInto(Actor::class.java)
    }

    fun findByActorIdIn(idList: List<Long>?): List<Actor> {
        return dslContext.selectFrom(ACTOR)
            .where(inIfNotEmpty(ACTOR.ACTOR_ID, idList))
            .fetchInto(Actor::class.java)
    }

    fun findActorFilmography(searchOption: ActorFilmographySearchOption): List<ActorFilmography> {
        val actorListMap = dslContext.select(
            ACTOR,
            FILM
        ).from(ACTOR)
            .join(FILM_ACTOR)
            .on(ACTOR.ACTOR_ID.eq(FILM_ACTOR.ACTOR_ID))
            .join(FILM)
            .on(FILM.FILM_ID.eq(FILM_ACTOR.FILM_ID))
            .where(
                containsIfNotBlank(
                    ACTOR.FIRST_NAME.concat(" ").concat(ACTOR.LAST_NAME),
                    searchOption.actorName
                ),
                containsIfNotBlank(FILM.TITLE, searchOption.filmTitle)
            ).fetchGroups(
                { record -> record[ACTOR.name, Actor::class.java] },
                { record -> record[FILM.name, Film::class.java] }
            )
        return actorListMap.entries.map { entry -> ActorFilmography(entry.key, entry.value) }

    }

    private fun containsIfNotBlank(field: Field<String?>, inputValue: String?): Condition {
        return if (inputValue.isNullOrBlank()) {
            noCondition()
        } else {
            field.like("%${inputValue}%")
        }
    }

    fun saveByDao(actor: Actor): Actor {
        actorDao.insert(actor)
        return actor
    }

    fun saveByRecord(actor: Actor): ActorRecord {
        val actorRecord = dslContext.newRecord(ACTOR, actor)
        actorRecord.insert()
        return actorRecord
    }

    fun saveWithReturningPkOnly(actor: Actor): Long? {
        return dslContext.insertInto(
            ACTOR,
            ACTOR.FIRST_NAME,
            ACTOR.LAST_NAME
        ).values(
            actor.firstName,
            actor.lastName
        ).returningResult(ACTOR.ACTOR_ID)
            .fetchOneInto(Long::class.java)


    }

    fun saveWithReturning(actor: Actor): Actor? {
        return dslContext.insertInto(
            ACTOR,
            ACTOR.FIRST_NAME,
            ACTOR.LAST_NAME
        ).values(
            actor.firstName, actor.lastName
        ).returning(*ACTOR.fields())
            .fetchOneInto(Actor::class.java)
    }

    fun bulkInsertWithRows(actorList: List<Actor>) {
        val rows = actorList.stream().map { actor ->
            row(actor.firstName, actor.lastName)
        }.toList()

        dslContext.insertInto(
            ACTOR,
            ACTOR.FIRST_NAME,
            ACTOR.LAST_NAME
        ).valuesOfRows(rows)
            .execute()
    }

    /*private fun inIfNotEmpty(field: Field<Long?>, idList: List<Long>): Condition {
        return if (CollectionUtils.isEmpty(idList)) {
            DSL.noCondition()
        } else {
            field.`in`(idList)
        }
    }*/

}