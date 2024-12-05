package com.example.jooqtest.insert

import com.example.jooqtest.actor.ActorRepository
import org.assertj.core.api.Assertions
import org.jooq.generated.tables.pojos.Actor
import org.jooq.generated.tables.records.ActorRecord
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@SpringBootTest
class JooqInsertTest {

    @Autowired
    lateinit var actorRepository: ActorRepository

    @Test
    @DisplayName("자동 생성 DAO insert")
    fun test_01(){
        // given
        val actor = Actor()
        actor.firstName = "John"
        actor.lastName = "Doe"

        // when
        actorRepository.saveByDao(actor)

        // then
        Assertions.assertThat(actor.actorId).isNotNull
    }

    @Test
    @DisplayName("ActiveRecord insert")
    @Transactional
    fun test_record(){
        // given
        val actor = Actor()
        actor.firstName = "John"
        actor.lastName = "Doe"

        // when
        val actorRecord: ActorRecord = actorRepository.saveByRecord(actor)

        // then
        Assertions.assertThat(actorRecord.actorId).isNotNull()
    }

    @Test
    @DisplayName("return PK")
    @Transactional
    fun return_pk(){
        // given
        val actor = Actor()
        actor.firstName = "John"
        actor.lastName = "Doe"
        actor.lastUpdate = LocalDateTime.now()

        // when
        val pk = actorRepository.saveWithReturningPkOnly(actor)

        // then
        Assertions.assertThat(pk).isNotNull()
    }

    @Test
    @DisplayName("row 반환")
    @Transactional
    fun return_row(){
        // given
        val actor = Actor()
        actor.firstName = "John"
        actor.lastName = "Doe"
        actor.lastUpdate = LocalDateTime.now()

        // when
        val newActor: Actor? = actorRepository.saveWithReturning(actor)

        // then
        Assertions.assertThat(newActor).hasNoNullFieldsOrProperties()

    }

    @Test
    @DisplayName("bulk")
    @Transactional
    fun test_bulk(){
        // given
        val actor1 = Actor()
        actor1.firstName = "John1"
        actor1.lastName = "Doe1"

        val actor2 = Actor()
        actor2.firstName = "John2"
        actor2.lastName = "Doe2"

        val actorList = listOf(actor1,actor2)

        actorRepository.bulkInsertWithRows(actorList)
    }

}