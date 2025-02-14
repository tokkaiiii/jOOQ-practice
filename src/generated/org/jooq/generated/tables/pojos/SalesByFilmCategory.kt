/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos


import java.io.Serializable
import java.math.BigDecimal


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class SalesByFilmCategory(
    var category: String? = null,
    var totalSales: BigDecimal? = null
): Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: SalesByFilmCategory = other as SalesByFilmCategory
        if (this.category == null) {
            if (o.category != null)
                return false
        }
        else if (this.category != o.category)
            return false
        if (this.totalSales == null) {
            if (o.totalSales != null)
                return false
        }
        else if (this.totalSales != o.totalSales)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.category == null) 0 else this.category.hashCode())
        result = prime * result + (if (this.totalSales == null) 0 else this.totalSales.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("SalesByFilmCategory (")

        sb.append(category)
        sb.append(", ").append(totalSales)

        sb.append(")")
        return sb.toString()
    }
}
