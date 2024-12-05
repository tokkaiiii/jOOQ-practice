package com.example.jooqtest.film

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SpringBootTest
class FilmServiceTest{
    @Autowired
    private lateinit var filmService: FilmService

    @Test
    fun test1(){
        val filmActorPageResponse = filmService.getFilmActorPageResponse(1L, 5L)
        println(filmActorPageResponse.filmActorList.stream().forEach { println(it.filmTitle) })

    }

    @Test
    fun test2(){
        filmService.getFilmCategoryPageResponse(1L,5L).also{
            it.filmCategories.stream().forEach { c ->
                println("""
                    필름아이디: ${c.filmId}
                    카테고리명: ${c.categoryName}
                    마지막 업데이트일 ${c.categoryLastUpdate}
                """.trimIndent()) }
        }
    }
}