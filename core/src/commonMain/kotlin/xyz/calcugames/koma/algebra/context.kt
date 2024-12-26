package xyz.calcugames.koma.algebra

import kotlin.reflect.KProperty

/**
 * Represents a base algebraic context.
 */
abstract class Context internal constructor(
    open val variables: Map<Variable, Number> = emptyMap()
) {
    open operator fun get(variable: Variable): Number = variables[variable] ?: error("Variable not set: $variable")
    operator fun contains(variable: Variable): Boolean = variable in variables

    operator fun Variable.getValue(thisRef: Any?, property: KProperty<*>): Number = this@Context[this]

    operator fun Variable.compareTo(value: Number): Int = this@Context[this].toDouble().compareTo(value.toDouble())
    operator fun Variable.compareTo(value: Variable): Int = this@Context[this].toDouble().compareTo(this@Context[value].toDouble())
    operator fun Number.compareTo(value: Variable): Int = this.toDouble().compareTo(this@Context[value].toDouble())
}

/**
 * Represents an algebraic context using [Double] numbers.
 */
class DoubleContext internal constructor(
    /**
     * The variables in the context.
     */
    override val variables: MutableMap<Variable, Double> = mutableMapOf()
) : Context() {
    override operator fun get(variable: Variable): Double = super.get(variable) as Double
    operator fun get(variable: Variable, default: Double): Double = variables[variable] ?: default

    operator fun Variable.plus(value: Double): Double = this@DoubleContext[this] + value
    operator fun Variable.plus(value: Float): Double = this@DoubleContext[this] + value
    operator fun Variable.plus(value: Long): Double = this@DoubleContext[this] + value
    operator fun Variable.plus(value: Int): Double = this@DoubleContext[this] + value
    operator fun Variable.plus(value: Variable): Double = this@DoubleContext[this] + this@DoubleContext[value]

    operator fun Variable.plusAssign(value: Double) {
        variables[this] = this@DoubleContext[this, 0.0] + value
    }
    operator fun Variable.plusAssign(value: Float) {
        variables[this] = this@DoubleContext[this, 0.0] + value
    }
    operator fun Variable.plusAssign(value: Long) {
        variables[this] = this@DoubleContext[this, 0.0] + value
    }
    operator fun Variable.plusAssign(value: Int) {
        variables[this] = this@DoubleContext[this, 0.0] + value
    }
    operator fun Variable.plusAssign(value: Variable) {
        variables[this] = this@DoubleContext[this, 0.0] + this@DoubleContext[value]
    }

    operator fun Variable.minus(value: Double): Double = this@DoubleContext[this] - value
    operator fun Variable.minus(value: Float): Double = this@DoubleContext[this] - value
    operator fun Variable.minus(value: Long): Double = this@DoubleContext[this] - value
    operator fun Variable.minus(value: Int): Double = this@DoubleContext[this] - value
    operator fun Variable.minus(value: Variable): Double = this@DoubleContext[this] - this@DoubleContext[value]

    operator fun Variable.minusAssign(value: Double) {
        variables[this] = this@DoubleContext[this, 0.0] - value
    }
    operator fun Variable.minusAssign(value: Float) {
        variables[this] = this@DoubleContext[this, 0.0] - value
    }
    operator fun Variable.minusAssign(value: Long) {
        variables[this] = this@DoubleContext[this, 0.0] - value
    }
    operator fun Variable.minusAssign(value: Int) {
        variables[this] = this@DoubleContext[this, 0.0] - value
    }
    operator fun Variable.minusAssign(value: Variable) {
        variables[this] = this@DoubleContext[this, 0.0] - this@DoubleContext[value]
    }

    operator fun Variable.times(value: Double): Double = this@DoubleContext[this] * value
    operator fun Variable.times(value: Float): Double = this@DoubleContext[this] * value
    operator fun Variable.times(value: Long): Double = this@DoubleContext[this] * value
    operator fun Variable.times(value: Int): Double = this@DoubleContext[this] * value
    operator fun Variable.times(value: Variable): Double = this@DoubleContext[this] * this@DoubleContext[value]

    operator fun Variable.timesAssign(value: Double) {
        variables[this] = this@DoubleContext[this, 0.0] * value
    }
    operator fun Variable.timesAssign(value: Float) {
        variables[this] = this@DoubleContext[this, 0.0] * value
    }
    operator fun Variable.timesAssign(value: Long) {
        variables[this] = this@DoubleContext[this, 0.0] * value
    }
    operator fun Variable.timesAssign(value: Int) {
        variables[this] = this@DoubleContext[this, 0.0] * value
    }
    operator fun Variable.timesAssign(value: Variable) {
        variables[this] = this@DoubleContext[this, 0.0] * this@DoubleContext[value]
    }

    operator fun Variable.div(value: Double): Double = this@DoubleContext[this] / value
    operator fun Variable.div(value: Float): Double = this@DoubleContext[this] / value
    operator fun Variable.div(value: Long): Double = this@DoubleContext[this] / value
    operator fun Variable.div(value: Int): Double = this@DoubleContext[this] / value
    operator fun Variable.div(value: Variable): Double = this@DoubleContext[this] / this@DoubleContext[value]

    operator fun Variable.divAssign(value: Double) {
        variables[this] = this@DoubleContext[this, 0.0] / value
    }
    operator fun Variable.divAssign(value: Float) {
        variables[this] = this@DoubleContext[this, 0.0] / value
    }
    operator fun Variable.divAssign(value: Long) {
        variables[this] = this@DoubleContext[this, 0.0] / value
    }
    operator fun Variable.divAssign(value: Int) {
        variables[this] = this@DoubleContext[this, 0.0] / value
    }
    operator fun Variable.divAssign(value: Variable) {
        variables[this] = this@DoubleContext[this, 0.0] / this@DoubleContext[value]
    }

    operator fun Variable.rem(value: Double): Double = this@DoubleContext[this] % value
    operator fun Variable.rem(value: Float): Double = this@DoubleContext[this] % value
    operator fun Variable.rem(value: Long): Double = this@DoubleContext[this] % value
    operator fun Variable.rem(value: Int): Double = this@DoubleContext[this] % value
    operator fun Variable.rem(value: Variable): Double = this@DoubleContext[this] % this@DoubleContext[value]

    operator fun Variable.remAssign(value: Double) {
        variables[this] = this@DoubleContext[this, 0.0] % value
    }
    operator fun Variable.remAssign(value: Float) {
        variables[this] = this@DoubleContext[this, 0.0] % value
    }
    operator fun Variable.remAssign(value: Long) {
        variables[this] = this@DoubleContext[this, 0.0] % value
    }
    operator fun Variable.remAssign(value: Int) {
        variables[this] = this@DoubleContext[this, 0.0] % value
    }
    operator fun Variable.remAssign(value: Variable) {
        variables[this] = this@DoubleContext[this, 0.0] % this@DoubleContext[value]
    }

    operator fun Variable.rangeTo(value: Double): ClosedRange<Double> = this@DoubleContext[this]..value
    operator fun Variable.rangeTo(value: Variable): ClosedRange<Double> = this@DoubleContext[this]..this@DoubleContext[value]
    operator fun Variable.rangeUntil(value: Double): OpenEndRange<Double> = this@DoubleContext[this]..<value
    operator fun Variable.rangeUntil(value: Variable): OpenEndRange<Double> = this@DoubleContext[this]..<this@DoubleContext[value]

    operator fun Variable.unaryPlus(): Double = +this@DoubleContext[this]
    operator fun Variable.unaryMinus(): Double = -this@DoubleContext[this]
}

/**
 * Represents an algebraic context using [Float] numbers.
 */
class FloatContext internal constructor(
    /**
     * The variables in the context.
     */
    override val variables: MutableMap<Variable, Float> = mutableMapOf()
) : Context() {
    override operator fun get(variable: Variable): Float = super.get(variable) as Float
    operator fun get(variable: Variable, default: Float): Float = variables[variable] ?: default

    operator fun Variable.plus(value: Double): Double = this@FloatContext[this] + value
    operator fun Variable.plus(value: Float): Float = this@FloatContext[this] + value
    operator fun Variable.plus(value: Long): Float = this@FloatContext[this] + value
    operator fun Variable.plus(value: Int): Float = this@FloatContext[this] + value
    operator fun Variable.plus(value: Variable): Float = this@FloatContext[this] + this@FloatContext[value]

    operator fun Variable.plusAssign(value: Float) {
        variables[this] = this@FloatContext[this, 0.0F] + value
    }
    operator fun Variable.plusAssign(value: Long) {
        variables[this] = this@FloatContext[this, 0.0F] + value
    }
    operator fun Variable.plusAssign(value: Int) {
        variables[this] = this@FloatContext[this, 0.0F] + value
    }
    operator fun Variable.plusAssign(value: Variable) {
        variables[this] = this@FloatContext[this, 0.0F] + this@FloatContext[value]
    }

    operator fun Variable.minus(value: Double): Double = this@FloatContext[this] - value
    operator fun Variable.minus(value: Float): Float = this@FloatContext[this] - value
    operator fun Variable.minus(value: Long): Float = this@FloatContext[this] - value
    operator fun Variable.minus(value: Int): Float = this@FloatContext[this] - value
    operator fun Variable.minus(value: Variable): Float = this@FloatContext[this] - this@FloatContext[value]

    operator fun Variable.minusAssign(value: Float) {
        variables[this] = this@FloatContext[this, 0.0F] - value
    }
    operator fun Variable.minusAssign(value: Long) {
        variables[this] = this@FloatContext[this, 0.0F] - value
    }
    operator fun Variable.minusAssign(value: Int) {
        variables[this] = this@FloatContext[this, 0.0F] - value
    }
    operator fun Variable.minusAssign(value: Variable) {
        variables[this] = this@FloatContext[this, 0.0F] - this@FloatContext[value]
    }

    operator fun Variable.times(value: Double): Double = this@FloatContext[this] * value
    operator fun Variable.times(value: Float): Float = this@FloatContext[this] * value
    operator fun Variable.times(value: Long): Float = this@FloatContext[this] * value
    operator fun Variable.times(value: Int): Float = this@FloatContext[this] * value
    operator fun Variable.times(value: Variable): Float = this@FloatContext[this] * this@FloatContext[value]

    operator fun Variable.timesAssign(value: Float) {
        variables[this] = this@FloatContext[this, 0.0F] * value
    }
    operator fun Variable.timesAssign(value: Long) {
        variables[this] = this@FloatContext[this, 0.0F] * value
    }
    operator fun Variable.timesAssign(value: Int) {
        variables[this] = this@FloatContext[this, 0.0F] * value
    }
    operator fun Variable.timesAssign(value: Variable) {
        variables[this] = this@FloatContext[this, 0.0F] * this@FloatContext[value]
    }

    operator fun Variable.div(value: Double): Double = this@FloatContext[this] / value
    operator fun Variable.div(value: Float): Float = this@FloatContext[this] / value
    operator fun Variable.div(value: Long): Float = this@FloatContext[this] / value
    operator fun Variable.div(value: Int): Float = this@FloatContext[this] / value
    operator fun Variable.div(value: Variable): Float = this@FloatContext[this] / this@FloatContext[value]

    operator fun Variable.divAssign(value: Float) {
        variables[this] = this@FloatContext[this, 0.0F] / value
    }
    operator fun Variable.divAssign(value: Long) {
        variables[this] = this@FloatContext[this, 0.0F] / value
    }
    operator fun Variable.divAssign(value: Int) {
        variables[this] = this@FloatContext[this, 0.0F] / value
    }
    operator fun Variable.divAssign(value: Variable) {
        variables[this] = this@FloatContext[this, 0.0F] / this@FloatContext[value]
    }

    operator fun Variable.rem(value: Double): Double = this@FloatContext[this] % value
    operator fun Variable.rem(value: Float): Float = this@FloatContext[this] % value
    operator fun Variable.rem(value: Long): Float = this@FloatContext[this] % value
    operator fun Variable.rem(value: Int): Float = this@FloatContext[this] % value
    operator fun Variable.rem(value: Variable): Float = this@FloatContext[this] % this@FloatContext[value]

    operator fun Variable.remAssign(value: Float) {
        variables[this] = this@FloatContext[this, 0.0F] % value
    }
    operator fun Variable.remAssign(value: Long) {
        variables[this] = this@FloatContext[this, 0.0F] % value
    }
    operator fun Variable.remAssign(value: Int) {
        variables[this] = this@FloatContext[this, 0.0F] % value
    }
    operator fun Variable.remAssign(value: Variable) {
        variables[this] = this@FloatContext[this, 0.0F] % this@FloatContext[value]
    }

    operator fun Variable.rangeTo(value: Float): ClosedRange<Float> = this@FloatContext[this]..value
    operator fun Variable.rangeTo(value: Variable): ClosedRange<Float> = this@FloatContext[this]..this@FloatContext[value]
    operator fun Variable.rangeUntil(value: Float): OpenEndRange<Float> = this@FloatContext[this]..<value
    operator fun Variable.rangeUntil(value: Variable): OpenEndRange<Float> = this@FloatContext[this]..<this@FloatContext[value]

    operator fun Variable.unaryPlus(): Float = +this@FloatContext[this]
    operator fun Variable.unaryMinus(): Float = -this@FloatContext[this]
}

/**
 * Represents an algebraic context using [Long] numbers.
 */
class LongContext internal constructor(
    /**
     * The variables in the context.
     */
    override val variables: MutableMap<Variable, Long> = mutableMapOf()
): Context() {
    override operator fun get(variable: Variable): Long = variables[variable] ?: error("Variable not set: $variable")
    operator fun get(variable: Variable, default: Long): Long = variables[variable] ?: default

    operator fun Variable.plus(value: Double): Double = this@LongContext[this] + value
    operator fun Variable.plus(value: Float): Float = this@LongContext[this] + value
    operator fun Variable.plus(value: Long): Long = this@LongContext[this] + value
    operator fun Variable.plus(value: Int): Long = this@LongContext[this] + value
    operator fun Variable.plus(value: Variable): Long = this@LongContext[this] + this@LongContext[value]

    operator fun Variable.plusAssign(value: Long) {
        variables[this] = this@LongContext[this, 0L] + value
    }
    operator fun Variable.plusAssign(value: Int) {
        variables[this] = this@LongContext[this, 0L] + value
    }
    operator fun Variable.plusAssign(value: Variable) {
        variables[this] = this@LongContext[this, 0L] + this@LongContext[value]
    }

    operator fun Variable.minus(value: Double): Double = this@LongContext[this] - value
    operator fun Variable.minus(value: Float): Float = this@LongContext[this] - value
    operator fun Variable.minus(value: Long): Long = this@LongContext[this] - value
    operator fun Variable.minus(value: Int): Long = this@LongContext[this] - value
    operator fun Variable.minus(value: Variable): Long = this@LongContext[this] - this@LongContext[value]

    operator fun Variable.minusAssign(value: Long) {
        variables[this] = this@LongContext[this, 0L] - value
    }
    operator fun Variable.minusAssign(value: Int) {
        variables[this] = this@LongContext[this, 0L] - value
    }
    operator fun Variable.minusAssign(value: Variable) {
        variables[this] = this@LongContext[this, 0L] - this@LongContext[value]
    }

    operator fun Variable.times(value: Double): Double = this@LongContext[this] * value
    operator fun Variable.times(value: Float): Float = this@LongContext[this] * value
    operator fun Variable.times(value: Long): Long = this@LongContext[this] * value
    operator fun Variable.times(value: Int): Long = this@LongContext[this] * value
    operator fun Variable.times(value: Variable): Long = this@LongContext[this] * this@LongContext[value]

    operator fun Variable.timesAssign(value: Long) {
        variables[this] = this@LongContext[this, 0L] * value
    }
    operator fun Variable.timesAssign(value: Int) {
        variables[this] = this@LongContext[this, 0L] * value
    }
    operator fun Variable.timesAssign(value: Variable) {
        variables[this] = this@LongContext[this, 0L] * this@LongContext[value]
    }

    operator fun Variable.div(value: Double): Double = this@LongContext[this] / value
    operator fun Variable.div(value: Float): Float = this@LongContext[this] / value
    operator fun Variable.div(value: Long): Long = this@LongContext[this] / value
    operator fun Variable.div(value: Int): Long = this@LongContext[this] / value
    operator fun Variable.div(value: Variable): Long = this@LongContext[this] / this@LongContext[value]

    operator fun Variable.divAssign(value: Long) {
        variables[this] = this@LongContext[this, 0L] / value
    }
    operator fun Variable.divAssign(value: Int) {
        variables[this] = this@LongContext[this, 0L] / value
    }
    operator fun Variable.divAssign(value: Variable) {
        variables[this] = this@LongContext[this, 0L] / this@LongContext[value]
    }

    operator fun Variable.rem(value: Double): Double = this@LongContext[this] % value
    operator fun Variable.rem(value: Float): Float = this@LongContext[this] % value
    operator fun Variable.rem(value: Long): Long = this@LongContext[this] % value
    operator fun Variable.rem(value: Int): Long = this@LongContext[this] % value
    operator fun Variable.rem(value: Variable): Long = this@LongContext[this] % this@LongContext[value]

    operator fun Variable.remAssign(value: Long) {
        variables[this] = this@LongContext[this, 0L] % value
    }
    operator fun Variable.remAssign(value: Int) {
        variables[this] = this@LongContext[this, 0L] % value
    }
    operator fun Variable.remAssign(value: Variable) {
        variables[this] = this@LongContext[this, 0L] % this@LongContext[value]
    }

    operator fun Variable.rangeTo(value: Long): ClosedRange<Long> = this@LongContext[this]..value
    operator fun Variable.rangeTo(value: Variable): ClosedRange<Long> = this@LongContext[this]..this@LongContext[value]
    operator fun Variable.rangeUntil(value: Long): OpenEndRange<Long> = this@LongContext[this]..<value
    operator fun Variable.rangeUntil(value: Variable): OpenEndRange<Long> = this@LongContext[this]..<this@LongContext[value]

    operator fun Variable.unaryPlus(): Long = +this@LongContext[this]
    operator fun Variable.unaryMinus(): Long = -this@LongContext[this]
}

/**
 * Represents an algebraic context using [Int] numbers.
 */
class IntContext internal constructor(
    /**
     * The variables in the context.
     */
    override val variables: MutableMap<Variable, Int> = mutableMapOf()
) : Context() {
    override operator fun get(variable: Variable): Int = variables[variable] ?: error("Variable not set: $variable")
    operator fun get(variable: Variable, default: Int): Int = variables[variable] ?: default

    operator fun Variable.plus(value: Double): Double = this@IntContext[this] + value
    operator fun Variable.plus(value: Float): Float = this@IntContext[this] + value
    operator fun Variable.plus(value: Long): Long = this@IntContext[this] + value
    operator fun Variable.plus(value: Int): Int = this@IntContext[this] + value
    operator fun Variable.plus(value: Variable): Int = this@IntContext[this] + this@IntContext[value]

    operator fun Variable.plusAssign(value: Int) {
        variables[this] = this@IntContext[this, 0] + value
    }
    operator fun Variable.plusAssign(value: Variable) {
        variables[this] = this@IntContext[this, 0] + this@IntContext[value]
    }

    operator fun Variable.minus(value: Double): Double = this@IntContext[this] - value
    operator fun Variable.minus(value: Float): Float = this@IntContext[this] - value
    operator fun Variable.minus(value: Long): Long = this@IntContext[this] - value
    operator fun Variable.minus(value: Int): Int = this@IntContext[this] - value
    operator fun Variable.minus(value: Variable): Int = this@IntContext[this] - this@IntContext[value]

    operator fun Variable.minusAssign(value: Int) {
        variables[this] = this@IntContext[this, 0] - value
    }
    operator fun Variable.minusAssign(value: Variable) {
        variables[this] = this@IntContext[this, 0] - this@IntContext[value]
    }

    operator fun Variable.times(value: Double): Double = this@IntContext[this] * value
    operator fun Variable.times(value: Float): Float = this@IntContext[this] * value
    operator fun Variable.times(value: Long): Long = this@IntContext[this] * value
    operator fun Variable.times(value: Int): Int = this@IntContext[this] * value
    operator fun Variable.times(value: Variable): Int = this@IntContext[this] * this@IntContext[value]

    operator fun Variable.timesAssign(value: Int) {
        variables[this] = this@IntContext[this, 0] * value
    }
    operator fun Variable.timesAssign(value: Variable) {
        variables[this] = this@IntContext[this, 0] * this@IntContext[value]
    }

    operator fun Variable.div(value: Double): Double = this@IntContext[this] / value
    operator fun Variable.div(value: Float): Float = this@IntContext[this] / value
    operator fun Variable.div(value: Long): Long = this@IntContext[this] / value
    operator fun Variable.div(value: Int): Int = this@IntContext[this] / value
    operator fun Variable.div(value: Variable): Int = this@IntContext[this] / this@IntContext[value]

    operator fun Variable.divAssign(value: Int) {
        variables[this] = this@IntContext[this, 0] / value
    }
    operator fun Variable.divAssign(value: Variable) {
        variables[this] = this@IntContext[this, 0] / this@IntContext[value]
    }

    operator fun Variable.rem(value: Double): Double = this@IntContext[this] % value
    operator fun Variable.rem(value: Float): Float = this@IntContext[this] % value
    operator fun Variable.rem(value: Long): Long = this@IntContext[this] % value
    operator fun Variable.rem(value: Int): Int = this@IntContext[this] % value
    operator fun Variable.rem(value: Variable): Int = this@IntContext[this] % this@IntContext[value]

    operator fun Variable.remAssign(value: Int) {
        variables[this] = this@IntContext[this, 0] % value
    }
    operator fun Variable.remAssign(value: Variable) {
        variables[this] = this@IntContext[this, 0] % this@IntContext[value]
    }

    operator fun Variable.rangeTo(value: Int): ClosedRange<Int> = this@IntContext[this]..value
    operator fun Variable.rangeTo(value: Variable): ClosedRange<Int> = this@IntContext[this]..this@IntContext[value]
    operator fun Variable.rangeUntil(value: Int): OpenEndRange<Int> = this@IntContext[this]..<value
    operator fun Variable.rangeUntil(value: Variable): OpenEndRange<Int> = this@IntContext[this]..<this@IntContext[value]

    operator fun Variable.unaryPlus(): Int = +this@IntContext[this]
    operator fun Variable.unaryMinus(): Int = -this@IntContext[this]
}

// Double

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 */
fun doubleContext(variables: Map<Variable, Double>, context: DoubleContext.() -> Unit) = DoubleContext(variables.toMutableMap()).apply(context)

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 */
fun doubleContext(variables: List<Pair<Variable, Double>>, context: DoubleContext.() -> Unit) = doubleContext(variables.associate { it.first to it.second }, context)

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 */
fun doubleContext(vararg variables: Pair<Variable, Double>, context: DoubleContext.() -> Unit) = doubleContext(mapOf(*variables), context)

/**
 * Creates a context with the given variables.
 * @param v1 The single variable in the context.
 * @param n1 The value of the variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Double, context: DoubleContext.() -> Unit) = doubleContext(mapOf(v1 to n1), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Double, v2: Variable, n2: Double, context: DoubleContext.() -> Unit) = doubleContext(mapOf(v1 to n1, v2 to n2), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Double, v2: Variable, n2: Double, v3: Variable, n3: Double, context: DoubleContext.() -> Unit) = doubleContext(mapOf(v1 to n1, v2 to n2, v3 to n3), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param v4 The fourth variable in the context.
 * @param n4 The value of the fourth variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Double, v2: Variable, n2: Double, v3: Variable, n3: Double, v4: Variable, n4: Double, context: DoubleContext.() -> Unit) = doubleContext(mapOf(v1 to n1, v2 to n2, v3 to n3, v4 to n4), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param v4 The fourth variable in the context.
 * @param n4 The value of the fourth variable.
 * @param v5 The fifth variable in the context.
 * @param n5 The value of the fifth variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Double, v2: Variable, n2: Double, v3: Variable, n3: Double, v4: Variable, n4: Double, v5: Variable, n5: Double, context: DoubleContext.() -> Unit) = doubleContext(mapOf(v1 to n1, v2 to n2, v3 to n3, v4 to n4, v5 to n5), context)

// Float

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 */
fun floatContext(variables: Map<Variable, Float>, context: FloatContext.() -> Unit) = FloatContext(variables.toMutableMap()).apply(context)

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 */
fun floatContext(variables: List<Pair<Variable, Float>>, context: FloatContext.() -> Unit) = floatContext(variables.associate { it.first to it.second }, context)

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 */
fun floatContext(vararg variables: Pair<Variable, Float>, context: FloatContext.() -> Unit) = floatContext(mapOf(*variables), context)

/**
 * Creates a context with the given variables.
 * @param v1 The single variable in the context.
 * @param n1 The value of the variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Float, context: FloatContext.() -> Unit) = floatContext(mapOf(v1 to n1), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Float, v2: Variable, n2: Float, context: FloatContext.() -> Unit) = floatContext(mapOf(v1 to n1, v2 to n2), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Float, v2: Variable, n2: Float, v3: Variable, n3: Float, context: FloatContext.() -> Unit) = floatContext(mapOf(v1 to n1, v2 to n2, v3 to n3), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param v4 The fourth variable in the context.
 * @param n4 The value of the fourth variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Float, v2: Variable, n2: Float, v3: Variable, n3: Float, v4: Variable, n4: Float, context: FloatContext.() -> Unit) = floatContext(mapOf(v1 to n1, v2 to n2, v3 to n3, v4 to n4), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param v4 The fourth variable in the context.
 * @param n4 The value of the fourth variable.
 * @param v5 The fifth variable in the context.
 * @param n5 The value of the fifth variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Float, v2: Variable, n2: Float, v3: Variable, n3: Float, v4: Variable, n4: Float, v5: Variable, n5: Float, context: FloatContext.() -> Unit) = floatContext(mapOf(v1 to n1, v2 to n2, v3 to n3, v4 to n4, v5 to n5), context)

// Long

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 */
fun longContext(variables: Map<Variable, Long>, context: LongContext.() -> Unit) = LongContext(variables.toMutableMap()).apply(context)

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 * @return The context.
 */
fun longContext(variables: List<Pair<Variable, Long>>, context: LongContext.() -> Unit) = longContext(variables.associate { it.first to it.second }, context)

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 */
fun longContext(vararg variables: Pair<Variable, Long>, context: LongContext.() -> Unit) = longContext(mapOf(*variables), context)

/**
 * Creates a context with the given variables.
 * @param v1 The single variable in the context.
 * @param n1 The value of the variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Long, context: LongContext.() -> Unit) = longContext(mapOf(v1 to n1), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Long, v2: Variable, n2: Long, context: LongContext.() -> Unit) = longContext(mapOf(v1 to n1, v2 to n2), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Long, v2: Variable, n2: Long, v3: Variable, n3: Long, context: LongContext.() -> Unit) = longContext(mapOf(v1 to n1, v2 to n2, v3 to n3), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param v4 The fourth variable in the context.
 * @param n4 The value of the fourth variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Long, v2: Variable, n2: Long, v3: Variable, n3: Long, v4: Variable, n4: Long, context: LongContext.() -> Unit) = longContext(mapOf(v1 to n1, v2 to n2, v3 to n3, v4 to n4), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param v4 The fourth variable in the context.
 * @param n4 The value of the fourth variable.
 * @param v5 The fifth variable in the context.
 * @param n5 The value of the fifth variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Long, v2: Variable, n2: Long, v3: Variable, n3: Long, v4: Variable, n4: Long, v5: Variable, n5: Long, context: LongContext.() -> Unit) = longContext(mapOf(v1 to n1, v2 to n2, v3 to n3, v4 to n4, v5 to n5), context)

// Int

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 * @return The context.
 */
fun intContext(variables: Map<Variable, Int>, context: IntContext.() -> Unit) = IntContext(variables.toMutableMap()).apply(context)

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 * @return The context.
 */
fun intContext(variables: List<Pair<Variable, Int>>, context: IntContext.() -> Unit) = intContext(variables.associate { it.first to it.second }, context)

/**
 * Creates a context with the given variables.
 * @param variables The variables in the context.
 * @param context The context to operate in.
 * @return The context.
 * @return The context.
 */
fun intContext(vararg variables: Pair<Variable, Int>, context: IntContext.() -> Unit) = intContext(mapOf(*variables), context)

/**
 * Creates a context with the given variables.
 * @param v1 The single variable in the context.
 * @param n1 The value of the variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Int, context: IntContext.() -> Unit) = intContext(mapOf(v1 to n1), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Int, v2: Variable, n2: Int, context: IntContext.() -> Unit) = intContext(mapOf(v1 to n1, v2 to n2), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Int, v2: Variable, n2: Int, v3: Variable, n3: Int, context: IntContext.() -> Unit) = intContext(mapOf(v1 to n1, v2 to n2, v3 to n3), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param v4 The fourth variable in the context.
 * @param n4 The value of the fourth variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Int, v2: Variable, n2: Int, v3: Variable, n3: Int, v4: Variable, n4: Int, context: IntContext.() -> Unit) = intContext(mapOf(v1 to n1, v2 to n2, v3 to n3, v4 to n4), context)

/**
 * Creates a context with the given variables.
 * @param v1 The first variable in the context.
 * @param n1 The value of the first variable.
 * @param v2 The second variable in the context.
 * @param n2 The value of the second variable.
 * @param v3 The third variable in the context.
 * @param n3 The value of the third variable.
 * @param v4 The fourth variable in the context.
 * @param n4 The value of the fourth variable.
 * @param v5 The fifth variable in the context.
 * @param n5 The value of the fifth variable.
 * @param context The context to operate in.
 * @return The context.
 */
fun withVariables(v1: Variable, n1: Int, v2: Variable, n2: Int, v3: Variable, n3: Int, v4: Variable, n4: Int, v5: Variable, n5: Int, context: IntContext.() -> Unit) = intContext(mapOf(v1 to n1, v2 to n2, v3 to n3, v4 to n4, v5 to n5), context)
