/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.records


import java.math.BigDecimal

import org.jooq.generated.tables.JSalesByStore
import org.jooq.generated.tables.pojos.SalesByStore
import org.jooq.impl.TableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class SalesByStoreRecord() : TableRecordImpl<SalesByStoreRecord>(JSalesByStore.SALES_BY_STORE) {

    open var store: String?
        set(value): Unit = set(0, value)
        get(): String? = get(0) as String?

    open var manager: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    open var totalSales: BigDecimal?
        set(value): Unit = set(2, value)
        get(): BigDecimal? = get(2) as BigDecimal?

    /**
     * Create a detached, initialised SalesByStoreRecord
     */
    constructor(store: String? = null, manager: String? = null, totalSales: BigDecimal? = null): this() {
        this.store = store
        this.manager = manager
        this.totalSales = totalSales
        resetChangedOnNotNull()
    }

    /**
     * Create a detached, initialised SalesByStoreRecord
     */
    constructor(value: SalesByStore?): this() {
        if (value != null) {
            this.store = value.store
            this.manager = value.manager
            this.totalSales = value.totalSales
            resetChangedOnNotNull()
        }
    }
}
