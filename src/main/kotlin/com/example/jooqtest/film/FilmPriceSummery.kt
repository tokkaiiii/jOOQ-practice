package com.example.jooqtest.film

import java.math.BigDecimal

class FilmPriceSummery(
    val filmId: Long,
    val title: String,
    val rentalRate: BigDecimal,
    val priceCategory: String,
    val totalInventory: Long
) {

    enum class PriceCategory(
        val code: String
    ){
        CHEAP("Cheap"),
        MODERATE("Moderate"),
        EXPENSIVE("Expensive");

        /*companion object {
            fun findByCode(code: String): PriceCategory?{
                return entries.find { it.code.equals(code, ignoreCase = true) }
            }
        }*/

    }
}