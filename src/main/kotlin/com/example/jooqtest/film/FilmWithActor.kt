package com.example.jooqtest.film

import org.jooq.generated.tables.pojos.Actor
import org.jooq.generated.tables.pojos.Film
import org.jooq.generated.tables.pojos.FilmActor

data class FilmWithActor(
    var film: Film? = null,
    var filmActor: FilmActor? = null,
    var actor: Actor? = null
){
    fun getTitle(): String? = film?.title
    fun getActorFullName(): String = "${actor?.firstName} ${actor?.lastName}"
    fun getFilmId(): Long? = film?.filmId


}
