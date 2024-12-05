package com.example.jooqtest.subquery

import com.example.jooqtest.film.FilmPriceSummery
import com.example.jooqtest.film.FilmRentalSummery
import com.example.jooqtest.film.FilmRepositoryHasA
import org.assertj.core.api.Assertions
import org.jooq.generated.tables.pojos.Film
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JooqSubqueryTest {

    @Autowired
    lateinit var filmRepository: FilmRepositoryHasA

    @Test
    @DisplayName("서브쿼리 테스트")
    fun test_01(){
        // given
        val filmTitle = "EGG"

        // when
        val priceSummeryList: List<FilmPriceSummery> = filmRepository.findFilmPriceSummeryByFilmTitle(filmTitle)

        // then
        Assertions.assertThat(priceSummeryList).isNotEmpty
    }

    @Test
    @DisplayName("from 절 서브쿼리")
    fun test_from_01(){
        // given
        val filmTitle = "EGG"

        // when
        val rentalSummeryList: List<FilmRentalSummery> = filmRepository.findFilmRentalSummeryByFilmTitle(filmTitle)

        // then
        Assertions.assertThat(rentalSummeryList).isNotEmpty
    }

    @Test
    @DisplayName("조회")
    fun test_02(){
        val filmTitle = "EGG"
        val filmList: List<Film> = filmRepository.findRentedFilmByTitle(filmTitle)
        Assertions.assertThat(filmList).isNotEmpty
    }

}