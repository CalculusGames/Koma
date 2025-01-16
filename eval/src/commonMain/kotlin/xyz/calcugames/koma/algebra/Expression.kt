package xyz.calcugames.koma.algebra

/**
 * Represents a step in the evaluation of an algebraic expression.
 */
class Step

/**
 * Represents an algebraic expression.
 */
class Expression

/**
 * Represents the context to build an algebraic expression.
 */
class ExpressionContext

fun expression(block: ExpressionContext.() -> Unit): Expression {
    val context = ExpressionContext()
    context.block()
    return Expression()
}