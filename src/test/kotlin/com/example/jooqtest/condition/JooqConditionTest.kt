package com.example.jooqtest.condition

import com.example.jooqtest.actor.ActorFilmography
import com.example.jooqtest.actor.ActorFilmographySearchOption
import com.example.jooqtest.actor.ActorRepository
import org.assertj.core.api.Assertions
import org.jooq.generated.tables.pojos.Actor
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JooqConditionTest{

    @Autowired
    private lateinit var actorRepository: ActorRepository

    @Test
    @DisplayName("and 조건 검색")
    fun test_01(){
        // given
        val firstName = "ED"
        val lastName = "CHASE"
        // when
        val actorList = actorRepository.findByFistNameAndLastName(firstName,lastName)

        // then
        Assertions.assertThat(actorList).isNotEmpty
        Assertions.assertThat(actorList).hasSize(1)
    }

    @Test
    @DisplayName("or 조건 검색")
    fun test_02(){
        // given
        val firstName = "ED"
        val lastName = "CHASE"
        // when
        val actorList = actorRepository.findByFistNameOrLastName(firstName,lastName)

        // then
        Assertions.assertThat(actorList).hasSizeGreaterThan(1)
    }

    @Test
    @DisplayName("in절 검색")
    fun test_03(){
        // when
        val actorList: List<Actor> = actorRepository.findByActorIdIn(listOf(1L,2L,3L))

        // then
        Assertions.assertThat(actorList).hasSize(3)
    }

    @Test
    @DisplayName("in 절 - empty list")
    fun test_04(){
        // when
        val actorList: List<Actor> = actorRepository.findByActorIdIn(emptyList())

        // then
        Assertions.assertThat(actorList).hasSizeGreaterThan(1)
    }

    @Test
    @DisplayName("다중 조건 검색")
    fun test_05(){
        // given
        val searchOption = ActorFilmographySearchOption(actorName = "LOLLOBRIGIDA")

        // when
         val actorFilmList: List<ActorFilmography> = actorRepository.findActorFilmography(searchOption)

        // then
        Assertions.assertThat(actorFilmList).hasSize(1)
        println(actorFilmList)
    }

    @Test
    @DisplayName("다중 조건 검색2")
    fun test_06(){
        // given
        val searchOption =
            ActorFilmographySearchOption(
                actorName = "LOLLOBRIGIDA",
                filmTitle = "COMMANDMENTS EXPRESS"
            )

        // when
        val actorFilmographies = actorRepository.findActorFilmography(searchOption)

        // then
        Assertions.assertThat(actorFilmographies).hasSize(1)
    }

}