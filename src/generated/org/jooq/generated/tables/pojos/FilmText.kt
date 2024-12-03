/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos


import java.io.Serializable


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class FilmText(
    var filmId: Int? = null,
    var title: String? = null,
    var description: String? = null
): Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: FilmText = other as FilmText
        if (this.filmId == null) {
            if (o.filmId != null)
                return false
        }
        else if (this.filmId != o.filmId)
            return false
        if (this.title == null) {
            if (o.title != null)
                return false
        }
        else if (this.title != o.title)
            return false
        if (this.description == null) {
            if (o.description != null)
                return false
        }
        else if (this.description != o.description)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.filmId == null) 0 else this.filmId.hashCode())
        result = prime * result + (if (this.title == null) 0 else this.title.hashCode())
        result = prime * result + (if (this.description == null) 0 else this.description.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("FilmText (")

        sb.append(filmId)
        sb.append(", ").append(title)
        sb.append(", ").append(description)

        sb.append(")")
        return sb.toString()
    }
}