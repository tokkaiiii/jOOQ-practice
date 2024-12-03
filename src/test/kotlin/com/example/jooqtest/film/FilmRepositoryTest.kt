package com.example.jooqtest.film

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FilmRepositoryTest{

    @Autowired
    private lateinit var filmRepository: FilmRepository

    @Test
    @DisplayName("영환 한 편 조회")
    fun test1(){
        val film = filmRepository.findById(1L)
        assertThat(film).isNotNull
    }

    @Test
    @DisplayName("영화 정보 간략 조회")
    fun test2(){
        val simpleInfoFilm = filmRepository.findFilmInfoById(1L)
        assertThat(simpleInfoFilm).hasNoNullFieldsOrProperties()
    }

    @Test
    @DisplayName("dd")
    fun test3(){
        val findFilmWithActorList = filmRepository.findFilmWithActorList(1L, 5L)
        assertThat(findFilmWithActorList).hasSize(5)
    }

}