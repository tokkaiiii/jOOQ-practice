/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables


import java.time.LocalDateTime

import kotlin.collections.Collection

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.InverseForeignKey
import org.jooq.Name
import org.jooq.Path
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
import org.jooq.generated.keys.FK_FILM_LANGUAGE
import org.jooq.generated.keys.FK_FILM_LANGUAGE_ORIGINAL
import org.jooq.generated.keys.KEY_LANGUAGE_PRIMARY
import org.jooq.generated.tables.JFilm.FilmPath
import org.jooq.generated.tables.records.LanguageRecord
import org.jooq.impl.AutoConverter
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl
import org.jooq.types.UInteger


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class JLanguage(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, LanguageRecord>?,
    parentPath: InverseForeignKey<out Record, LanguageRecord>?,
    aliased: Table<LanguageRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<LanguageRecord>(
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
         * The reference instance of <code>sakila.language</code>
         */
        val LANGUAGE: JLanguage = JLanguage()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<LanguageRecord> = LanguageRecord::class.java

    /**
     * The column <code>sakila.language.language_id</code>.
     */
    val LANGUAGE_ID: TableField<LanguageRecord, Long?> = createField(DSL.name("language_id"), SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "", AutoConverter<UInteger, Long>(UInteger::class.java, Long::class.java))

    /**
     * The column <code>sakila.language.name</code>.
     */
    val NAME: TableField<LanguageRecord, String?> = createField(DSL.name("name"), SQLDataType.CHAR(20).nullable(false), this, "")

    /**
     * The column <code>sakila.language.last_update</code>.
     */
    val LAST_UPDATE: TableField<LanguageRecord, LocalDateTime?> = createField(DSL.name("last_update"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field(DSL.raw("CURRENT_TIMESTAMP"), SQLDataType.LOCALDATETIME)), this, "")

    private constructor(alias: Name, aliased: Table<LanguageRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<LanguageRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<LanguageRecord>?, where: Condition): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>sakila.language</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>sakila.language</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>sakila.language</code> table reference
     */
    constructor(): this(DSL.name("language"), null)

    constructor(path: Table<out Record>, childPath: ForeignKey<out Record, LanguageRecord>?, parentPath: InverseForeignKey<out Record, LanguageRecord>?): this(Internal.createPathAlias(path, childPath, parentPath), path, childPath, parentPath, LANGUAGE, null, null)

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    open class LanguagePath : JLanguage, Path<LanguageRecord> {
        constructor(path: Table<out Record>, childPath: ForeignKey<out Record, LanguageRecord>?, parentPath: InverseForeignKey<out Record, LanguageRecord>?): super(path, childPath, parentPath)
        private constructor(alias: Name, aliased: Table<LanguageRecord>): super(alias, aliased)
        override fun `as`(alias: String): LanguagePath = LanguagePath(DSL.name(alias), this)
        override fun `as`(alias: Name): LanguagePath = LanguagePath(alias, this)
        override fun `as`(alias: Table<*>): LanguagePath = LanguagePath(alias.qualifiedName, this)
    }
    override fun getSchema(): Schema? = if (aliased()) null else JSakila.SAKILA
    override fun getIdentity(): Identity<LanguageRecord, Long?> = super.getIdentity() as Identity<LanguageRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<LanguageRecord> = KEY_LANGUAGE_PRIMARY

    private lateinit var _fkFilmLanguage: FilmPath

    /**
     * Get the implicit to-many join path to the <code>sakila.film</code> table,
     * via the <code>fk_film_language</code> key
     */
    fun fkFilmLanguage(): FilmPath {
        if (!this::_fkFilmLanguage.isInitialized)
            _fkFilmLanguage = FilmPath(this, null, FK_FILM_LANGUAGE.inverseKey)

        return _fkFilmLanguage;
    }

    val fkFilmLanguage: FilmPath
        get(): FilmPath = fkFilmLanguage()

    private lateinit var _fkFilmLanguageOriginal: FilmPath

    /**
     * Get the implicit to-many join path to the <code>sakila.film</code> table,
     * via the <code>fk_film_language_original</code> key
     */
    fun fkFilmLanguageOriginal(): FilmPath {
        if (!this::_fkFilmLanguageOriginal.isInitialized)
            _fkFilmLanguageOriginal = FilmPath(this, null, FK_FILM_LANGUAGE_ORIGINAL.inverseKey)

        return _fkFilmLanguageOriginal;
    }

    val fkFilmLanguageOriginal: FilmPath
        get(): FilmPath = fkFilmLanguageOriginal()
    override fun `as`(alias: String): JLanguage = JLanguage(DSL.name(alias), this)
    override fun `as`(alias: Name): JLanguage = JLanguage(alias, this)
    override fun `as`(alias: Table<*>): JLanguage = JLanguage(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): JLanguage = JLanguage(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): JLanguage = JLanguage(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): JLanguage = JLanguage(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition): JLanguage = JLanguage(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): JLanguage = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition): JLanguage = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>): JLanguage = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): JLanguage = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): JLanguage = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): JLanguage = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): JLanguage = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): JLanguage = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): JLanguage = where(DSL.notExists(select))
}
