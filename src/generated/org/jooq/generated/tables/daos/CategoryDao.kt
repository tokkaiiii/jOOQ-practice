/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos


import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.generated.tables.JCategory
import org.jooq.generated.tables.pojos.Category
import org.jooq.generated.tables.records.CategoryRecord
import org.jooq.impl.AutoConverter
import org.jooq.impl.DAOImpl
import org.jooq.types.UInteger


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class CategoryDao(configuration: Configuration?) : DAOImpl<CategoryRecord, Category, Long>(JCategory.CATEGORY, Category::class.java, configuration) {

    /**
     * Create a new CategoryDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: Category): Long? = o.categoryId

    /**
     * Fetch records that have <code>category_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJCategoryId(lowerInclusive: Long?, upperInclusive: Long?): List<Category> = fetchRange(JCategory.CATEGORY.CATEGORY_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>category_id IN (values)</code>
     */
    fun fetchByJCategoryId(vararg values: Long): List<Category> = fetch(JCategory.CATEGORY.CATEGORY_ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>category_id = value</code>
     */
    fun fetchOneByJCategoryId(value: Long): Category? = fetchOne(JCategory.CATEGORY.CATEGORY_ID, value)

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJName(lowerInclusive: String?, upperInclusive: String?): List<Category> = fetchRange(JCategory.CATEGORY.NAME, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    fun fetchByJName(vararg values: String): List<Category> = fetch(JCategory.CATEGORY.NAME, *values)

    /**
     * Fetch records that have <code>last_update BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJLastUpdate(lowerInclusive: LocalDateTime?, upperInclusive: LocalDateTime?): List<Category> = fetchRange(JCategory.CATEGORY.LAST_UPDATE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>last_update IN (values)</code>
     */
    fun fetchByJLastUpdate(vararg values: LocalDateTime): List<Category> = fetch(JCategory.CATEGORY.LAST_UPDATE, *values)
}
