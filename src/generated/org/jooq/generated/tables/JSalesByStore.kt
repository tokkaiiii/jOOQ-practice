/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables


import java.math.BigDecimal

import kotlin.collections.Collection

import org.jooq.Condition
import org.jooq.Field
import org.jooq.ForeignKey
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
import org.jooq.generated.JSakila
import org.jooq.generated.tables.records.SalesByStoreRecord
import org.jooq.impl.DSL
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class JSalesByStore(
    alias: Name,
    path: Table<out Record>?,
    childPath: ForeignKey<out Record, SalesByStoreRecord>?,
    parentPath: InverseForeignKey<out Record, SalesByStoreRecord>?,
    aliased: Table<SalesByStoreRecord>?,
    parameters: Array<Field<*>?>?,
    where: Condition?
): TableImpl<SalesByStoreRecord>(
    alias,
    JSakila.SAKILA,
    path,
    childPath,
    parentPath,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.view("create view `sales_by_store` as select concat(`c`.`city`,',',`cy`.`country`) AS `store`,concat(`m`.`first_name`,' ',`m`.`last_name`) AS `manager`,sum(`p`.`amount`) AS `total_sales` from (((((((`sakila`.`payment` `p` join `sakila`.`rental` `r` on((`p`.`rental_id` = `r`.`rental_id`))) join `sakila`.`inventory` `i` on((`r`.`inventory_id` = `i`.`inventory_id`))) join `sakila`.`store` `s` on((`i`.`store_id` = `s`.`store_id`))) join `sakila`.`address` `a` on((`s`.`address_id` = `a`.`address_id`))) join `sakila`.`city` `c` on((`a`.`city_id` = `c`.`city_id`))) join `sakila`.`country` `cy` on((`c`.`country_id` = `cy`.`country_id`))) join `sakila`.`staff` `m` on((`s`.`manager_staff_id` = `m`.`staff_id`))) group by `s`.`store_id` order by `cy`.`country`,`c`.`city`"),
    where,
) {
    companion object {

        /**
         * The reference instance of <code>sakila.sales_by_store</code>
         */
        val SALES_BY_STORE: JSalesByStore = JSalesByStore()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<SalesByStoreRecord> = SalesByStoreRecord::class.java

    /**
     * The column <code>sakila.sales_by_store.store</code>.
     */
    val STORE: TableField<SalesByStoreRecord, String?> = createField(DSL.name("store"), SQLDataType.VARCHAR(101).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>sakila.sales_by_store.manager</code>.
     */
    val MANAGER: TableField<SalesByStoreRecord, String?> = createField(DSL.name("manager"), SQLDataType.VARCHAR(91).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "")

    /**
     * The column <code>sakila.sales_by_store.total_sales</code>.
     */
    val TOTAL_SALES: TableField<SalesByStoreRecord, BigDecimal?> = createField(DSL.name("total_sales"), SQLDataType.DECIMAL(27, 2), this, "")

    private constructor(alias: Name, aliased: Table<SalesByStoreRecord>?): this(alias, null, null, null, aliased, null, null)
    private constructor(alias: Name, aliased: Table<SalesByStoreRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, null, aliased, parameters, null)
    private constructor(alias: Name, aliased: Table<SalesByStoreRecord>?, where: Condition): this(alias, null, null, null, aliased, null, where)

    /**
     * Create an aliased <code>sakila.sales_by_store</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>sakila.sales_by_store</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>sakila.sales_by_store</code> table reference
     */
    constructor(): this(DSL.name("sales_by_store"), null)
    override fun getSchema(): Schema? = if (aliased()) null else JSakila.SAKILA
    override fun `as`(alias: String): JSalesByStore = JSalesByStore(DSL.name(alias), this)
    override fun `as`(alias: Name): JSalesByStore = JSalesByStore(alias, this)
    override fun `as`(alias: Table<*>): JSalesByStore = JSalesByStore(alias.qualifiedName, this)

    /**
     * Rename this table
     */
    override fun rename(name: String): JSalesByStore = JSalesByStore(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): JSalesByStore = JSalesByStore(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): JSalesByStore = JSalesByStore(name.qualifiedName, null)

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Condition): JSalesByStore = JSalesByStore(qualifiedName, if (aliased()) this else null, condition)

    /**
     * Create an inline derived table from this table
     */
    override fun where(conditions: Collection<Condition>): JSalesByStore = where(DSL.and(conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(vararg conditions: Condition): JSalesByStore = where(DSL.and(*conditions))

    /**
     * Create an inline derived table from this table
     */
    override fun where(condition: Field<Boolean?>): JSalesByStore = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(condition: SQL): JSalesByStore = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String): JSalesByStore = where(DSL.condition(condition))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg binds: Any?): JSalesByStore = where(DSL.condition(condition, *binds))

    /**
     * Create an inline derived table from this table
     */
    @PlainSQL override fun where(@Stringly.SQL condition: String, vararg parts: QueryPart): JSalesByStore = where(DSL.condition(condition, *parts))

    /**
     * Create an inline derived table from this table
     */
    override fun whereExists(select: Select<*>): JSalesByStore = where(DSL.exists(select))

    /**
     * Create an inline derived table from this table
     */
    override fun whereNotExists(select: Select<*>): JSalesByStore = where(DSL.notExists(select))
}