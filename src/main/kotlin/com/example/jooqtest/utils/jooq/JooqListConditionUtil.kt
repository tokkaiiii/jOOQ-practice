package com.example.jooqtest.utils.jooq

import org.jooq.Condition
import org.jooq.Field
import org.jooq.impl.DSL
import org.springframework.util.CollectionUtils

object JooqListConditionUtil {

    fun <T> inIfNotEmpty(actorId: Field<T>, idList: List<T>?): Condition {
        return if (CollectionUtils.isEmpty(idList)) {
            DSL.noCondition()
        } else {
            actorId.`in`(idList)
        }
    }
}

