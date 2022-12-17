package org.jetbrains.kotlinx.ggdsl.letsplot.layers.context

import org.jetbrains.kotlinx.ggdsl.dsl.internal.LayerCollectorContextImmutable
import org.jetbrains.kotlinx.ggdsl.dsl.internal.LayerCollectorContextMutable
import org.jetbrains.kotlinx.ggdsl.dsl.internal.PlotDslMarker
import org.jetbrains.kotlinx.ggdsl.letsplot.internal.AlphaAes
import org.jetbrains.kotlinx.ggdsl.letsplot.internal.FillAes
import org.jetbrains.kotlinx.ggdsl.letsplot.internal.XAes
import org.jetbrains.kotlinx.ggdsl.letsplot.internal.YAes

public interface AreaContextInterface: WithBorderLineContextInterface {
    public val x: XAes get() = XAes(this)
    public val y: YAes get() = YAes(this)

    public val color: FillAes get() = FillAes(this)
    public val alpha: AlphaAes get() = AlphaAes(this)
}

@PlotDslMarker
public class AreaContextImmutable(parent: LayerCollectorContextImmutable)
    : LayerWithBorderLineContextImmutable(parent), AreaContextInterface

@PlotDslMarker
public class AreaContextMutable(parent: LayerCollectorContextMutable):
    LayerWithBorderLineContextMutable(parent), AreaContextInterface