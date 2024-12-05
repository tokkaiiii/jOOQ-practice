package com.example.jooqtest.actor

import org.jooq.generated.tables.references.NICER_BUT_SLOWER_FILM_LIST

data class ActorFilmographySearchOption(
    val actorName: String? = null,
    val filmTitle: String? = null
)
