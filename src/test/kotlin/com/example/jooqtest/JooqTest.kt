package com.example.jooqtest

import org.jooq.DSLContext
import org.jooq.generated.tables.JActor
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JooqTest(
    @Autowired private val dslContext: DSLContext
) {

    @Test
    fun test(){
        dslContext.selectFrom(JActor.ACTOR)
            .limit(10)
            .fetch()
    }


}