package com.example.jooqtest.film

import org.jooq.Configuration
import org.jooq.DSLContext
import org.jooq.generated.tables.JFilm
import org.jooq.generated.tables.daos.FilmDao
import org.springframework.stereotype.Repository

@Repository
class FilmRepositoryIsA(
    configuration: Configuration,
    private val dslContext: DSLContext
) : FilmDao(configuration)