package org.jetbrains.kotlinx.kandy.letsplot.facet.feature

import kotlinx.serialization.Serializable
import org.jetbrains.kotlinx.kandy.ir.feature.FeatureName
import org.jetbrains.kotlinx.kandy.ir.feature.PlotFeature
import org.jetbrains.kotlinx.kandy.letsplot.facet.OrderDirection
import org.jetbrains.kotlinx.kandy.letsplot.facet.ScalesSharing

/**
 * Splits data by one or two faceting variables.
 * For each data subset creates a plot panel and lays out panels as grid.
 * The grid columns are defined by X faceting variable and rows are defined by Y faceting variable.
 *
 * @param x Variable name which defines columns of the facet grid.
 * @param y Variable name which defines rows of the facet grid.
 * @param scalesSharing Specifies whether scales are shared across all facets.
 * @param xOrder Specifies ordering direction of columns
 * @param yOrder Specifies ordering direction of rows
 * @param xFormat Specifies the format pattern for displaying faceting values in columns.
 * @param yFormat Specifies the format pattern for displaying faceting values in rows.
 *
 * Format pattern in the xFormat/yFormat parameters can be just a number format (like "d") or
 * a string template where number format is surrounded by curly braces: "{d} cylinders".
 * Note: the "$" must be escaped as "\$"
 *
 * Examples:
 * ".2f" -> "12.45"
 * "Score: {.2f}" -> "Score: 12.45"
 * "'Score: {}' "-> "Score: 12.454789"
 */
//@Serializable
public data class FacetGridFeature constructor(
    val x: String?,
    val y: String?,
    val scalesSharing: ScalesSharing?,
    val xOrder: OrderDirection,
    val yOrder: OrderDirection,
    val xFormat: String?,
    val yFormat: String?
) : PlotFeature {
    override val featureName: FeatureName = FEATURE_NAME

    public companion object {
        public val FEATURE_NAME: FeatureName = FeatureName("FACET_GRID_FEATURE")
    }

}