/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos


import java.io.Serializable


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class ActorInfo(
    var actorId: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var filmInfo: String? = null
): Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: ActorInfo = other as ActorInfo
        if (this.actorId == null) {
            if (o.actorId != null)
                return false
        }
        else if (this.actorId != o.actorId)
            return false
        if (this.firstName == null) {
            if (o.firstName != null)
                return false
        }
        else if (this.firstName != o.firstName)
            return false
        if (this.lastName == null) {
            if (o.lastName != null)
                return false
        }
        else if (this.lastName != o.lastName)
            return false
        if (this.filmInfo == null) {
            if (o.filmInfo != null)
                return false
        }
        else if (this.filmInfo != o.filmInfo)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.actorId == null) 0 else this.actorId.hashCode())
        result = prime * result + (if (this.firstName == null) 0 else this.firstName.hashCode())
        result = prime * result + (if (this.lastName == null) 0 else this.lastName.hashCode())
        result = prime * result + (if (this.filmInfo == null) 0 else this.filmInfo.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("ActorInfo (")

        sb.append(actorId)
        sb.append(", ").append(firstName)
        sb.append(", ").append(lastName)
        sb.append(", ").append(filmInfo)

        sb.append(")")
        return sb.toString()
    }
}