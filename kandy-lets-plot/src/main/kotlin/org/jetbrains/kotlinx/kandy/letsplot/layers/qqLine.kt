/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.letsplot.layers


/* TODO
@PublishedApi

 */
//public val QQ_LINE: LetsPlotGeom = LetsPlotGeom("qqLine")

/*
/*@PlotDslMarker*/
// todo move x/y?
<<<<<<< HEAD
class QQLineContext(
    parent: LayerCollectorContext,
=======
public class QQLineContext(
    override var data: MutableNamedData,
>>>>>>> main
    distribution: Distribution?,
    quantiles: Pair<Double, Double>?,
) : LayerContext(parent) {
    init {
        distribution?.let {
            distribution(it.name)
            dParams(it.toList())
        }
        quantiles?.let {
            quantiles(it)
        }
    }

    @PublishedApi
    internal val _sample: SampleAes get() = SampleAes(this)

    public val sample: SampleDummyAes get() = SampleDummyAes(this)

    public val alpha: AlphaAes get() = AlphaAes(this)
    public val color: ColorAes get() = ColorAes(this)
    public val width: SizeAes get() = SizeAes(this)
    public val type: LineTypeAes get() = LineTypeAes(this)


    // todo weight

    @PublishedApi
    internal val distribution: DistributionAes get() = DistributionAes(this)

    @PublishedApi
    internal val dParams: DParamsAes get() = DParamsAes(this)

    @PublishedApi
    internal val quantiles: QuantilesAes get() = QuantilesAes(this)

    public object Statistics {
        public val SAMPLE: QQStat.Sample = QQStat.Sample
        public val THEORETICAL: QQStat.Theoretical = QQStat.Theoretical
    }

    public val Stat: Statistics = Statistics


    public inline operator fun <reified DomainType> ScalablePositionalAes.invoke(
        stat: QQStat<DomainType>
    ): ScaledUnspecifiedDefaultPositionalMapping<DomainType> {
        val mapping = ScaledUnspecifiedDefaultPositionalMapping(
            this.name,
            stat.toDataSource().scaled(),
            typeOf<DomainType>()
        )
        context.bindingCollector.mappings[this.name] = mapping
        return mapping
    }

    public inline operator fun <reified DomainType, RangeType> MappableNonPositionalAes<RangeType>.invoke(
        stat: QQStat<DomainType>
    ): ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType> {
        val mapping = ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType>(
            this.name,
            stat.toDataSource().scaled(),
            typeOf<DomainType>()
        )
        context.bindingCollector.mappings[this.name] = mapping
        return mapping
    }

}

<<<<<<< HEAD
inline fun <reified T> PlotContext.qqLine(
    source: ColumnReference<T>,
=======
public inline fun <reified T> PlotContext.qqLine(
    source: DataSource<T>,
>>>>>>> main
    distribution: Distribution? = null,
    quantiles: Pair<Double, Double>? = null,
    block: QQLineContext.() -> Unit
) {
    layers.add(
        QQLineContext(data, distribution, quantiles)
            .apply {
                copyFrom(this@qqLine)
                _sample(source)
            }
            .apply(block)
            .toLayer(QQ_LINE)
    )
}

public inline fun <reified T> PlotContext.qqLine(
    source: Iterable<T>,
    distribution: Distribution? = null,
    quantiles: Pair<Double, Double>? = null,
    block: QQLineContext.() -> Unit
) {
    layers.add(
        QQLineContext(data, distribution, quantiles)
            .apply {
                copyFrom(this@qqLine)
                _sample(source)
            }
            .apply(block)
            .toLayer(QQ_LINE)
    )
}

 */

