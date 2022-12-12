package org.jetbrains.kotlinx.ggdsl.echarts.translator.option.series.settings.marks

import kotlinx.serialization.Serializable
import org.jetbrains.kotlinx.ggdsl.echarts.features.marks.MarkPointFeature
import org.jetbrains.kotlinx.ggdsl.echarts.translator.option.series.settings.Blur
import org.jetbrains.kotlinx.ggdsl.echarts.translator.option.series.settings.Emphasis
import org.jetbrains.kotlinx.ggdsl.echarts.translator.option.series.settings.ItemStyle
import org.jetbrains.kotlinx.ggdsl.echarts.translator.option.series.settings.Label
import org.jetbrains.kotlinx.ggdsl.echarts.translator.serializers.DataMarkPointSerializer
import org.jetbrains.kotlinx.ggdsl.ir.feature.FeatureName
import org.jetbrains.kotlinx.ggdsl.ir.feature.LayerFeature

internal fun Map<FeatureName, LayerFeature>.toEchartsMarkPoint(): EchartsMarkPoint? {
    val dataMarkPoints = (this[MarkPointFeature.FEATURE_NAME] as? MarkPointFeature)?.points?.map {
        DataMarkPoint(it.name, it.type?.type, it.valueMP, it.coord?.toList(), it.x, it.y)
    }

    return if (dataMarkPoints != null) {
        EchartsMarkPoint(data = dataMarkPoints)
    } else {
        null
    }
}

@Serializable(with = DataMarkPointSerializer::class)
public data class DataMarkPoint(
    val name: String? = null,
    val type: String? = null,
    val value: String? = null,
    val coord: List<Number>? = null,
    val x: String? = null,
    val y: String? = null,
    val xAxis: String? = null,
    val yAxis: String? = null,
)

@Serializable
public data class EchartsMarkPoint(
    val symbol: String? = null,
    val symbolSize: Int? = null,
    val symbolRotate: Int? = null,
    val symbolKeepAspect: Boolean? = null,
    val symbolOffset: Pair<String, String>? = null,
    val silent: Boolean? = null,
    val label: Label? = null,
    val itemStyle: ItemStyle? = null,
    val emphasis: Emphasis? = null,
    val blur: Blur? = null,
    val data: List<DataMarkPoint>? = null,
    val animation: Boolean? = null,
    val animationThreshold: Int? = null,
    val animationDuration: Int? = null,
    val animationEasing: String? = null,
    val animationDelay: Int? = null,
    val animationDurationUpdate: Int? = null,
    val animationEasingUpdate: String? = null,
    val animationDelayUpdate: Int? = null,
)