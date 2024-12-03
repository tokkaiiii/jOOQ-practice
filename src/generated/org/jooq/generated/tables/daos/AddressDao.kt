/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.daos


import java.time.LocalDateTime

import kotlin.collections.List

import org.jooq.Configuration
import org.jooq.generated.tables.JAddress
import org.jooq.generated.tables.pojos.Address
import org.jooq.generated.tables.records.AddressRecord
import org.jooq.impl.AutoConverter
import org.jooq.impl.DAOImpl
import org.jooq.types.UInteger


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class AddressDao(configuration: Configuration?) : DAOImpl<AddressRecord, Address, Long>(JAddress.ADDRESS, Address::class.java, configuration) {

    /**
     * Create a new AddressDao without any configuration
     */
    constructor(): this(null)

    override fun getId(o: Address): Long? = o.addressId

    /**
     * Fetch records that have <code>address_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJAddressId(lowerInclusive: Long?, upperInclusive: Long?): List<Address> = fetchRange(JAddress.ADDRESS.ADDRESS_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>address_id IN (values)</code>
     */
    fun fetchByJAddressId(vararg values: Long): List<Address> = fetch(JAddress.ADDRESS.ADDRESS_ID, *values.toTypedArray())

    /**
     * Fetch a unique record that has <code>address_id = value</code>
     */
    fun fetchOneByJAddressId(value: Long): Address? = fetchOne(JAddress.ADDRESS.ADDRESS_ID, value)

    /**
     * Fetch records that have <code>address BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJAddress(lowerInclusive: String?, upperInclusive: String?): List<Address> = fetchRange(JAddress.ADDRESS.ADDRESS_, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>address IN (values)</code>
     */
    fun fetchByJAddress(vararg values: String): List<Address> = fetch(JAddress.ADDRESS.ADDRESS_, *values)

    /**
     * Fetch records that have <code>address2 BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJAddress2(lowerInclusive: String?, upperInclusive: String?): List<Address> = fetchRange(JAddress.ADDRESS.ADDRESS2, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>address2 IN (values)</code>
     */
    fun fetchByJAddress2(vararg values: String): List<Address> = fetch(JAddress.ADDRESS.ADDRESS2, *values)

    /**
     * Fetch records that have <code>district BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJDistrict(lowerInclusive: String?, upperInclusive: String?): List<Address> = fetchRange(JAddress.ADDRESS.DISTRICT, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>district IN (values)</code>
     */
    fun fetchByJDistrict(vararg values: String): List<Address> = fetch(JAddress.ADDRESS.DISTRICT, *values)

    /**
     * Fetch records that have <code>city_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJCityId(lowerInclusive: Long?, upperInclusive: Long?): List<Address> = fetchRange(JAddress.ADDRESS.CITY_ID, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>city_id IN (values)</code>
     */
    fun fetchByJCityId(vararg values: Long): List<Address> = fetch(JAddress.ADDRESS.CITY_ID, *values.toTypedArray())

    /**
     * Fetch records that have <code>postal_code BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJPostalCode(lowerInclusive: String?, upperInclusive: String?): List<Address> = fetchRange(JAddress.ADDRESS.POSTAL_CODE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>postal_code IN (values)</code>
     */
    fun fetchByJPostalCode(vararg values: String): List<Address> = fetch(JAddress.ADDRESS.POSTAL_CODE, *values)

    /**
     * Fetch records that have <code>phone BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJPhone(lowerInclusive: String?, upperInclusive: String?): List<Address> = fetchRange(JAddress.ADDRESS.PHONE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>phone IN (values)</code>
     */
    fun fetchByJPhone(vararg values: String): List<Address> = fetch(JAddress.ADDRESS.PHONE, *values)

    /**
     * Fetch records that have <code>last_update BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    fun fetchRangeOfJLastUpdate(lowerInclusive: LocalDateTime?, upperInclusive: LocalDateTime?): List<Address> = fetchRange(JAddress.ADDRESS.LAST_UPDATE, lowerInclusive, upperInclusive)

    /**
     * Fetch records that have <code>last_update IN (values)</code>
     */
    fun fetchByJLastUpdate(vararg values: LocalDateTime): List<Address> = fetch(JAddress.ADDRESS.LAST_UPDATE, *values)
}
