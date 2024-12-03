/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos


import java.io.Serializable
import java.time.LocalDateTime


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Address(
    var addressId: Long? = null,
    var address: String? = null,
    var address2: String? = null,
    var district: String? = null,
    var cityId: Long? = null,
    var postalCode: String? = null,
    var phone: String? = null,
    var lastUpdate: LocalDateTime? = null
): Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: Address = other as Address
        if (this.addressId == null) {
            if (o.addressId != null)
                return false
        }
        else if (this.addressId != o.addressId)
            return false
        if (this.address == null) {
            if (o.address != null)
                return false
        }
        else if (this.address != o.address)
            return false
        if (this.address2 == null) {
            if (o.address2 != null)
                return false
        }
        else if (this.address2 != o.address2)
            return false
        if (this.district == null) {
            if (o.district != null)
                return false
        }
        else if (this.district != o.district)
            return false
        if (this.cityId == null) {
            if (o.cityId != null)
                return false
        }
        else if (this.cityId != o.cityId)
            return false
        if (this.postalCode == null) {
            if (o.postalCode != null)
                return false
        }
        else if (this.postalCode != o.postalCode)
            return false
        if (this.phone == null) {
            if (o.phone != null)
                return false
        }
        else if (this.phone != o.phone)
            return false
        if (this.lastUpdate == null) {
            if (o.lastUpdate != null)
                return false
        }
        else if (this.lastUpdate != o.lastUpdate)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.addressId == null) 0 else this.addressId.hashCode())
        result = prime * result + (if (this.address == null) 0 else this.address.hashCode())
        result = prime * result + (if (this.address2 == null) 0 else this.address2.hashCode())
        result = prime * result + (if (this.district == null) 0 else this.district.hashCode())
        result = prime * result + (if (this.cityId == null) 0 else this.cityId.hashCode())
        result = prime * result + (if (this.postalCode == null) 0 else this.postalCode.hashCode())
        result = prime * result + (if (this.phone == null) 0 else this.phone.hashCode())
        result = prime * result + (if (this.lastUpdate == null) 0 else this.lastUpdate.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("Address (")

        sb.append(addressId)
        sb.append(", ").append(address)
        sb.append(", ").append(address2)
        sb.append(", ").append(district)
        sb.append(", ").append(cityId)
        sb.append(", ").append(postalCode)
        sb.append(", ").append(phone)
        sb.append(", ").append(lastUpdate)

        sb.append(")")
        return sb.toString()
    }
}