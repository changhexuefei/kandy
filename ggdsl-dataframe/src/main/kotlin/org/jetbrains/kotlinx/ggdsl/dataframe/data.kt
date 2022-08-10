package org.jetbrains.kotlinx.ggdsl.dataframe

import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.asColumnGroup
import org.jetbrains.kotlinx.dataframe.api.flatten
import org.jetbrains.kotlinx.dataframe.api.toMap
import org.jetbrains.kotlinx.dataframe.columns.ColumnGroup
import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.ggdsl.ir.data.*
import kotlin.reflect.typeOf

@PublishedApi
internal inline fun <reified T: Any> ColumnReference<T>.toDataSource(): DataSource<T> {
    return DataSource(name(), typeOf<T>())
}

/*
fun DataFrame<*>.toNamedData(): NamedData {
    return toMap().map { it.key to it.value.map { it!! /*TODO*/ } }.toMap()
}

 */
/*
fun DataFrame<*>.toNamedData(): NamedData {
    return columns().flatMap {
        if (it is ColumnGroup<*>) {
            it.asColumnGroup().columns().map {
                it.name() to it.values().map { it!! }
            }
        } else {
           listOf(it.name() to it.values().map { it!! })
        }
    }.toMap()
}

 */

fun DataFrame<*>.toNamedData(): NamedData {
    return flatten().toMap().map { it.key to it.value.map { it!! /*TODO*/ } }.toMap()
}