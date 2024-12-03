/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos


import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.generated.tables.JStore
import org.jooq.generated.tables.pojos.Store
import org.jooq.generated.tables.records.StoreRecord
import org.jooq.impl.AutoConverter
import org.jooq.impl.DAOImpl
import org.jooq.types.UInteger


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class StoreDao(configuration: Configuration?) : DAOImpl<StoreRecord, Store, Long>(JStore.STORE, Store::class.java, configuration) {

    /**
     * Create a new StoreDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: Store): Long? = o.storeId

    /**
     * Fetch records that have <code>store_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJStoreId(lowerInclusive: Long?, upperInclusive: Long?): List<Store> = fetchRange(JStore.STORE.STORE_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>store_id IN (values)</code>
     */
    fun fetchByJStoreId(vararg values: Long): List<Store> = fetch(JStore.STORE.STORE_ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>store_id = value</code>
     */
    fun fetchOneByJStoreId(value: Long): Store? = fetchOne(JStore.STORE.STORE_ID, value)

    /**
     * Fetch records that have <code>manager_staff_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJManagerStaffId(lowerInclusive: Long?, upperInclusive: Long?): List<Store> = fetchRange(JStore.STORE.MANAGER_STAFF_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>manager_staff_id IN (values)</code>
     */
    fun fetchByJManagerStaffId(vararg values: Long): List<Store> = fetch(JStore.STORE.MANAGER_STAFF_ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>manager_staff_id = value</code>
     */
    fun fetchOneByJManagerStaffId(value: Long): Store? = fetchOne(JStore.STORE.MANAGER_STAFF_ID, value)

    /**
     * Fetch records that have <code>address_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJAddressId(lowerInclusive: Long?, upperInclusive: Long?): List<Store> = fetchRange(JStore.STORE.ADDRESS_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>address_id IN (values)</code>
     */
    fun fetchByJAddressId(vararg values: Long): List<Store> = fetch(JStore.STORE.ADDRESS_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>last_update BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJLastUpdate(lowerInclusive: LocalDateTime?, upperInclusive: LocalDateTime?): List<Store> = fetchRange(JStore.STORE.LAST_UPDATE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>last_update IN (values)</code>
     */
    fun fetchByJLastUpdate(vararg values: LocalDateTime): List<Store> = fetch(JStore.STORE.LAST_UPDATE, *values)
}
