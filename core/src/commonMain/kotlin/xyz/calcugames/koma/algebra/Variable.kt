package xyz.calcugames.koma.algebra

import xyz.calcugames.koma.Term

/**
 * Represents a variable as a single character.
 */
abstract class Variable(
    /**
     * The character representing the variable.
     */
    val character: Char
) : Term {

    override fun toString(): String = character.toString()

}

/**
 * Represents the variable 'a'.
 */
object A : Variable('a')

/**
 * Represents the variable 'b'.
 */
object B : Variable('b')

/**
 * Represents the variable 'c'.
 */
object C : Variable('c')

/**
 * Represents the variable 'd'.
 */
object D : Variable('d')

/**
 * Represents the variable 'e'.
 */
object E : Variable('e')

/**
 * Represents the variable 'f'.
 */
object F : Variable('f')

/**
 * Represents the variable 'g'.
 */
object G : Variable('g')

/**
 * Represents the variable 'h'.
 */
object H : Variable('h')

/**
 * Represents the variable 'i'.
 */
object I : Variable('i')

/**
 * Represents the variable 'j'.
 */
object J : Variable('j')

/**
 * Represents the variable 'k'.
 */
object K : Variable('k')

/**
 * Represents the variable 'l'.
 */
object L : Variable('l')

/**
 * Represents the variable 'm'.
 */
object M : Variable('m')

/**
 * Represents the variable 'n'.
 */
object N : Variable('n')

/**
 * Represents the variable 'o'.
 */
object O : Variable('o')

/**
 * Represents the variable 'p'.
 */
object P : Variable('p')

/**
 * Represents the variable 'q'.
 */
object Q : Variable('q')

/**
 * Represents the variable 'r'.
 */
object R : Variable('r')

/**
 * Represents the variable 's'.
 */
object S : Variable('s')

/**
 * Represents the variable 't'.
 */
object T : Variable('t')

/**
 * Represents the variable 'u'.
 */
object U : Variable('u')

/**
 * Represents the variable 'v'.
 */
object V : Variable('v')

/**
 * Represents the variable 'w'.
 */
object W : Variable('w')

/**
 * Represents the variable 'x'.
 */
object X : Variable('x')

/**
 * Represents the variable 'y'.
 */
object Y : Variable('y')

/**
 * Represents the variable 'z'.
 */
object Z : Variable('z')

/**
 * Represents the variable 'θ'.
 */
object THETA : Variable('θ')