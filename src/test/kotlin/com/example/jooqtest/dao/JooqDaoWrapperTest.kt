package com.example.jooqtest.dao

import com.example.jooqtest.film.FilmRepositoryHasA
import com.example.jooqtest.film.FilmRepositoryIsA
import org.assertj.core.api.Assertions
import org.jooq.generated.tables.pojos.Film
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JooqDaoWrapperTest {

    @Autowired
    lateinit var filmRepositoryIsA: FilmRepositoryIsA

    @Autowired
    lateinit var filmRepositoryHasA: FilmRepositoryHasA

    @Test
    @DisplayName("")
    fun test_01() {
        // when
        val film = filmRepositoryIsA.findById(1L)

        // then
        Assertions.assertThat(film).isNotNull
    }

    @Test
    @DisplayName("자동생성 DAO 사용 조회")
    fun test_DAO_01() {
        // given
        val start = 100
        val end = 180

        // when
        val films = filmRepositoryIsA.fetchRangeOfJLength(start, end)

        // then
        Assertions.assertThat(films).allSatisfy { film ->
            Assertions.assertThat(film.length).isBetween(start, end)
        }
    }

    @Test
    @DisplayName("컴포지션 DAO 사용 조회")
    fun test_DAO_02(){
        // given
        val start = 100
        val end = 180

        // when
        val films: List<Film> = filmRepositoryHasA.findByRangeBetween(start, end)

        // then
        Assertions.assertThat(films).allSatisfy {film ->
            Assertions.assertThat(film.length).isBetween(start,end)
        }
    }


}
