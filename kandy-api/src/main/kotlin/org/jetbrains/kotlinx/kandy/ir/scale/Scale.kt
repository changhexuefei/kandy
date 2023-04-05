/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.ir.scale

/**
 * Scale base interface. Scale wraps a function that converts
 * a value from a data source into some geometric value (value of aesthetic attribute).
 */
public sealed interface Scale {
    public companion object
}

/**
 * Continuous scale interface. Continuous scale wraps a function
 * that acts from one segment to another.
 */
public interface ContinuousScale<RangeType> : Scale {
    public val nullValue: RangeType?
    public val transform: Transform?
}

/**
 * Categorical scale interface. Categorical scale wraps a function
 * that acts from one finite set to another.
 */
public interface CategoricalScale : Scale