package xyz.calcugames.koma.algebra

import xyz.calcugames.koma.Term

/**
 * Represents a variable as a single character.
 */
abstract class Variable internal constructor(
    /**
     * The character representing the variable.
     */
    val character: Char
) : Term {

    override fun toString(): String = character.toString()

}

/**
 * Creates a variable from a character.
 * @param character The character representing the variable.
 * @return The variable.
 */
fun variable(character: Char): Variable = object : Variable(character) {}

/**
 * Represents the variable 'a'.
 */
object A : Variable('a')

/**
 * Represents the variable 'A'.
 */
object CA : Variable('A')

/**
 * Represents the variable 'b'.
 */
object B : Variable('b')

/**
 * Represents the variable 'B'.
 */
object CB : Variable('B')

/**
 * Represents the variable 'c'.
 */
object C : Variable('c')

/**
 * Represents the variable 'C'.
 */
object CC : Variable('C')

/**
 * Represents the variable 'd'.
 */
object D : Variable('d')

/**
 * Represents the variable 'D'.
 */
object CD : Variable('D')

/**
 * Represents the variable 'e'.
 */
object E : Variable('e')

/**
 * Represents the variable 'E'.
 */
object CE : Variable('E')

/**
 * Represents the variable 'f'.
 */
object F : Variable('f')

/**
 * Represents the variable 'F'.
 */
object CF : Variable('F')

/**
 * Represents the variable 'g'.
 */
object G : Variable('g')

/**
 * Represents the variable 'G'.
 */
object CG : Variable('G')

/**
 * Represents the variable 'h'.
 */
object H : Variable('h')

/**
 * Represents the variable 'H'.
 */
object CH : Variable('H')

/**
 * Represents the variable 'i'.
 */
object I : Variable('i')

/**
 * Represents the variable 'I'.
 */
object CI : Variable('I')

/**
 * Represents the variable 'j'.
 */
object J : Variable('j')

/**
 * Represents the variable 'J'.
 */
object CJ : Variable('J')

/**
 * Represents the variable 'k'.
 */
object K : Variable('k')

/**
 * Represents the variable 'K'.
 */
object CK : Variable('K')

/**
 * Represents the variable 'l'.
 */
object L : Variable('l')

/**
 * Represents the variable 'L'.
 */
object CL : Variable('L')

/**
 * Represents the variable 'm'.
 */
object M : Variable('m')

/**
 * Represents the variable 'M'.
 */
object CM : Variable('M')

/**
 * Represents the variable 'n'.
 */
object N : Variable('n')

/**
 * Represents the variable 'N'.
 */
object CN : Variable('N')

/**
 * Represents the variable 'o'.
 */
object O : Variable('o')

/**
 * Represents the variable 'O'.
 */
object CO : Variable('O')

/**
 * Represents the variable 'p'.
 */
object P : Variable('p')

/**
 * Represents the variable 'P'.
 */
object CP : Variable('P')

/**
 * Represents the variable 'q'.
 */
object Q : Variable('q')

/**
 * Represents the variable 'Q'.
 */
object CQ : Variable('Q')

/**
 * Represents the variable 'r'.
 */
object R : Variable('r')

/**
 * Represents the variable 'R'.
 */
object CR : Variable('R')

/**
 * Represents the variable 's'.
 */
object S : Variable('s')

/**
 * Represents the variable 'S'.
 */
object CS : Variable('S')

/**
 * Represents the variable 't'.
 */
object T : Variable('t')

/**
 * Represents the variable 'T'.
 */
object CT : Variable('T')

/**
 * Represents the variable 'u'.
 */
object U : Variable('u')

/**
 * Represents the variable 'U'.
 */
object CU : Variable('U')

/**
 * Represents the variable 'v'.
 */
object V : Variable('v')

/**
 * Represents the variable 'V'.
 */
object CV : Variable('V')

/**
 * Represents the variable 'w'.
 */
object W : Variable('w')

/**
 * Represents the variable 'W'.
 */
object CW : Variable('W')

/**
 * Represents the variable 'x'.
 */
object X : Variable('x')

/**
 * Represents the variable 'X'.
 */
object CX : Variable('X')

/**
 * Represents the variable 'y'.
 */
object Y : Variable('y')

/**
 * Represents the variable 'Y'.
 */
object CY : Variable('Y')

/**
 * Represents the variable 'z'.
 */
object Z : Variable('z')

/**
 * Represents the variable 'Z'.
 */
object CZ : Variable('Z')

/**
 * Represents the variable 'α'.
 */
object ALPHA : Variable('α')

/**
 * Represents the variable 'β'.
 */
object BETA : Variable('β')

/**
 * Represents the variable 'γ'.
 */
object GAMMA : Variable('γ')

/**
 * Represents the variable 'δ'.
 */
object DELTA : Variable('δ')

/**
 * Represents the variable 'ε'.
 */
object EPSILON : Variable('ε')

/**
 * Represents the variable 'ζ'.
 */
object ZETA : Variable('ζ')

/**
 * Represents the variable 'η'.
 */
object ETA : Variable('η')

/**
 * Represents the variable 'θ'.
 */
object THETA : Variable('θ')

/**
 * Represents the variable 'ι'.
 */
object IOTA : Variable('ι')

/**
 * Represents the variable 'κ'.
 */
object KAPPA : Variable('κ')

/**
 * Represents the variable 'λ'.
 */
object LAMBDA : Variable('λ')

/**
 * Represents the variable 'μ'.
 */
object MU : Variable('μ')

/**
 * Represents the variable 'ν'.
 */
object NU : Variable('ν')

/**
 * Represents the variable 'ξ'.
 */
object XI : Variable('ξ')