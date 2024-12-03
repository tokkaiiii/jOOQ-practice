package com.example.jooqtest.film

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FilmServiceTest{
    @Autowired
    private lateinit var filmService: FilmService

    @Test
    fun test1(){
        val filmActorPageResponse = filmService.getFilmActorPageResponse(1L, 5L)
        println(filmActorPageResponse.filmActorList.stream().forEach { println(it.filmTitle) })

    }
}