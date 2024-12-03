/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables


import kotlin.collections.Collection
import kotlin.collections.List

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Index
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.PlainSQL
import org.jooq.QueryPart
import org.jooq.Record
import org.jooq.SQL
import org.jooq.Schema
import org.jooq.Select
import org.jooq.Stringly
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.generated.JSakila
import org.jooq.generated.indexes.FILM_TEXT_IDX_TITLE_DESCRIPTION
import org.jooq.generated.keys.KEY_FILM_TEXT_PRIMARY
import org.jooq.generated.tables.records.FilmTextRecord
import org.jooq.impl.DSL
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class JFilmText(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, FilmTextRecord>?,
    parentPath: InverseForeignKey<out Record, FilmTextRecord>?,
    aliased: Table<FilmTextRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<FilmTextRecord>(
    alias,
    JSakila.SAKILA,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table(),
    where,
) {
    companion object {

        /**
         * The reference instance of <code>sakila.film_text</code>
         */
        val FILM_TEXT: JFilmText = JFilmText()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<FilmTextRecord> = FilmTextRecord::class.java

    /**
     * The column <code>sakila.film_text.film_id</code>.
     */
    val FILM_ID: TableField<FilmTextRecord, Int?> = createField(DSL.name("film_id"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>sakila.film_text.title</code>.
     */
    val TITLE: TableField<FilmTextRecord, String?> = createField(DSL.name("title"), SQLDataType.VARCHAR(255).nullable(false), this, "")

    /**
     * The column <code>sakila.film_text.description</code>.
     */
    val DESCRIPTION: TableField<FilmTextRecord, String?> = createField(DSL.name("description"), SQLDataType.CLOB, this, "")

    private constructor(alias: Name, aliased: Table<FilmTextRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<FilmTextRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<FilmTextRecord>?, where: Condition): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>sakila.film_text</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>sakila.film_text</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>sakila.film_text</code> table reference
     */
    constructor(): this(DSL.name("film_text"), null)
    override fun getSchema(): Schema? = if (aliased()) null else JSakila.SAKILA
    override fun getIndexes(): List<Index> = listOf(FILM_TEXT_IDX_TITLE_DESCRIPTION)
    override fun getPrimaryKey(): UniqueKey<FilmTextRecord> = KEY_FILM_TEXT_PRIMARY
    override fun `as`(alias: String): JFilmText = JFilmText(DSL.name(alias), this)
    override fun `as`(alias: Name): JFilmText = JFilmText(alias, this)
    override fun `as`(alias: Table<*>): JFilmText = JFilmText(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): JFilmText = JFilmText(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): JFilmText = JFilmText(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): JFilmText = JFilmText(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition): JFilmText = JFilmText(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): JFilmText = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition): JFilmText = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>): JFilmText = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): JFilmText = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): JFilmText = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): JFilmText = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): JFilmText = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): JFilmText = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): JFilmText = where(DSL.notExists(select))
}
