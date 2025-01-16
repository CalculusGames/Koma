package xyz.calcugames.koma

/**
 * Represents a mathematical operation.
 * @param char The character representation of the operation.
 */
abstract class Operation(val char: Char) : Term {
    override fun toString(): String = char.toString()
}

/**
 * Represents the addition operation.
 */
object PLUS : Operation('+')

/**
 * Represents the subtraction operation.
 */
object MINUS : Operation('-')

/**
 * Represents the multiplication operation.
 */
object TIMES : Operation('*')

/**
 * Represents the division operation.
 */
object DIV : Operation('/')

/**
 * Represents the exponentiation operation.
 */
object POW : Operation('^')

/**
 * Represents the modulo operation.
 */
object MOD : Operation('%')