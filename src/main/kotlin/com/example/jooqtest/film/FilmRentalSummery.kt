package com.example.jooqtest.film

import java.math.BigDecimal

data class FilmRentalSummery(
    val filmId: Long,
    val title: String,
    val averageRentalDuration: BigDecimal
)