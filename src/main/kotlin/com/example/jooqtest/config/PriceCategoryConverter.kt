package com.example.jooqtest.config

import com.example.jooqtest.film.FilmPriceSummery
import org.jooq.impl.EnumConverter

class PriceCategoryConverter: EnumConverter<String,FilmPriceSummery.PriceCategory>(
    String::class.java,
    FilmPriceSummery.PriceCategory::class.java,
    {it.code}
)
