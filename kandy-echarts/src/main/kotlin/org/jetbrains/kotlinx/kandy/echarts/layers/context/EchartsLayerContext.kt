/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.echarts.layers.context

import org.jetbrains.kotlinx.kandy.dsl.internal.LayerBuilderImpl
import org.jetbrains.kotlinx.kandy.dsl.internal.LayerCreatorScope
import org.jetbrains.kotlinx.kandy.echarts.features.animation.Animation
import org.jetbrains.kotlinx.kandy.echarts.features.animation.AnimationBoxplotCandlestick
import org.jetbrains.kotlinx.kandy.echarts.features.animation.AnimationLayerFeature
import org.jetbrains.kotlinx.kandy.echarts.features.animation.AnimationPie
import org.jetbrains.kotlinx.kandy.echarts.layers.aes.NAME
import org.jetbrains.kotlinx.kandy.ir.aes.Aes

@Suppress("INVISIBLE_MEMBER")
public sealed class EchartsLayerBuilder(parent: LayerCreatorScope) : LayerBuilderImpl(parent) {

    override val requiredAes: Set<Aes> = setOf()
    public var name: String? = null
        set(value) {
            bindingHandler.addNonPositionalSetting(NAME, value)
        }

    public operator fun Animation.invoke(block: Animation.() -> Unit): Animation = apply(block).also {
        it.toAnimationLayerFeature()?.let { feature ->
            this@EchartsLayerBuilder.layerFeatures[AnimationLayerFeature.FEATURE_NAME] = feature
        }
    }

    public operator fun AnimationPie.invoke(block: AnimationPie.() -> Unit): AnimationPie = apply(block).also {
        it.toAnimationFeature()?.let { feature ->
            this@EchartsLayerBuilder.layerFeatures[AnimationLayerFeature.FEATURE_NAME] = feature
        }
    }

    public operator fun AnimationBoxplotCandlestick.invoke(block: AnimationBoxplotCandlestick.() -> Unit): AnimationBoxplotCandlestick =
        apply(block).also {
            it.toAnimationFeature()?.let { feature ->
                this@EchartsLayerBuilder.layerFeatures[AnimationLayerFeature.FEATURE_NAME] = feature
            }
        }
}