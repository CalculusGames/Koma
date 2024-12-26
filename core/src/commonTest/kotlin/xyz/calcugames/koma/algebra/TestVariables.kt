package xyz.calcugames.koma.algebra

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TestVariables {

    @Test
    fun testAddition() {
        doubleContext(C to 5.0) {
            assertTrue(C + 5.0 == 10.0)
            assertFalse(C + 5.0 == 5.0)

            K += 5.0
            assertEquals(get(K), 5.0)

            C += K
            assertEquals(get(C), 10.0)
        }

        floatContext(A to 5.0F) {
            assertTrue(A + 5.0F == 10.0F)
            assertFalse(A + 5.0F == 5.0F)

            K += 5.0F
            assertEquals(get(K), 5.0F)

            A += K
            assertEquals(get(A), 10.0F)
        }

        longContext(D to 5L) {
            assertTrue(D + 5L == 10L)
            assertFalse(D + 5L == 5L)

            K += 5L
            assertEquals(get(K), 5L)

            D += K
            assertEquals(get(D), 10L)
        }

        intContext(B to 5) {
            assertTrue(B + 5 == 10)
            assertFalse(B + 5 == 5)

            K += 5
            assertEquals(get(K), 5)

            B += K
            assertEquals(get(B), 10)
        }
    }

    @Test
    fun testSubtraction() {
        doubleContext(C to 5.0) {
            assertTrue(C - 5.0 == 0.0)
            assertFalse(C - 5.0 == 5.0)

            K -= 5.0
            assertEquals(get(K), -5.0)

            C -= K
            assertEquals(get(C), 10.0)
        }

        floatContext(A to 5.0F) {
            assertTrue(A - 5.0F == 0.0F)
            assertFalse(A - 5.0F == 5.0F)

            K -= 5.0F
            assertEquals(get(K), -5.0F)

            A -= K
            assertEquals(get(A), 10.0F)
        }

        longContext(D to 5L) {
            assertTrue(D - 5L == 0L)
            assertFalse(D - 5L == 5L)

            K -= 5L
            assertEquals(get(K), -5L)

            D -= K
            assertEquals(get(D), 10L)
        }

        intContext(B to 5) {
            assertTrue(B - 5 == 0)
            assertFalse(B - 5 == 5)

            K -= 5
            assertEquals(get(K), -5)

            B -= K
            assertEquals(get(B), 10)
        }
    }

    @Test
    fun testMultiplication() {
        doubleContext(C to 5.0) {
            assertTrue(C * 5.0 == 25.0)
            assertFalse(C * 5.0 == 5.0)

            K += 1.0
            K *= 5.0
            assertEquals(get(K), 5.0)

            C *= K
            assertEquals(get(C), 25.0)
        }

        floatContext(A to 5.0F) {
            assertTrue(A * 5.0F == 25.0F)
            assertFalse(A * 5.0F == 5.0F)

            K += 1.0F
            K *= 5.0F
            assertEquals(get(K), 5.0F)

            A *= K
            assertEquals(get(A), 25.0F)
        }

        longContext(D to 5L) {
            assertTrue(D * 5L == 25L)
            assertFalse(D * 5L == 5L)

            K += 1L
            K *= 5L
            assertEquals(get(K), 5L)

            D *= K
            assertEquals(get(D), 25L)
        }

        intContext(B to 5) {
            assertTrue(B * 5 == 25)
            assertFalse(B * 5 == 5)

            K += 1
            K *= 5
            assertEquals(get(K), 5)

            B *= K
            assertEquals(get(B), 25)
        }
    }

    @Test
    fun testDivision() {
        doubleContext(C to 5.0) {
            assertTrue(C / 5.0 == 1.0)
            assertFalse(C / 5.0 == 5.0)

            K += 1.0
            K /= 5.0
            assertEquals(get(K), 0.2)

            C /= K
            assertEquals(get(C), 25.0)
        }

        floatContext(A to 5.0F) {
            assertTrue(A / 5.0F == 1.0F)
            assertFalse(A / 5.0F == 5.0F)

            K += 1.0F
            K /= 5.0F
            assertEquals(get(K), 0.2F)

            A /= K
            assertEquals(get(A), 25.0F)
        }

        longContext(D to 5L) {
            assertTrue(D / 5L == 1L)
            assertFalse(D / 5L == 5L)

            K += 1L
            assertEquals(get(K), 1L)

            K /= 5L
            assertEquals(get(K), 0L)
        }

        intContext(B to 5) {
            assertTrue(B / 5 == 1)
            assertFalse(B / 5 == 5)

            K += 1
            assertEquals(get(K), 1)

            K /= 5
            assertEquals(get(K), 0)
        }
    }

    @Test
    fun testRemainder() {
        doubleContext(C to 5.0) {
            assertTrue(C % 5.0 == 0.0)
            assertFalse(C % 5.0 == 5.0)

            K += 1.0
            assertEquals(get(K), 1.0)

            K %= 5.0
            assertEquals(get(K), 1.0)
        }

        floatContext(A to 5.0F) {
            assertTrue(A % 5.0F == 0.0F)
            assertFalse(A % 5.0F == 5.0F)

            K += 1.0F
            assertEquals(get(K), 1.0F)

            K %= 5.0F
            assertEquals(get(K), 1.0F)
        }

        longContext(D to 5L) {
            assertTrue(D % 5L == 0L)
            assertFalse(D % 5L == 5L)

            K += 1L
            assertEquals(get(K), 1L)

            K %= 5L
            assertEquals(get(K), 1L)
        }

        intContext(X to 5) {
            assertTrue(X % 5 == 0)
            assertFalse(X % 5 == 5)

            K += 1
            assertEquals(get(K), 1)

            K %= 5
            assertEquals(get(K), 1)
        }
    }

    @Test
    fun testCompare() {
        intContext(M to 1, L to 2) {
            assertTrue { M > 0 }
            assertTrue { M >= 0 }
            assertFalse { M < 0 }
            assertFalse { M <= 0 }

            assertTrue { 1 < L }
            assertTrue { 1 <= L }
            assertFalse { 1 > L }
            assertFalse { 1 >= L }

            assertTrue { M < L }
            assertTrue { M <= L }
            assertFalse { M > L }
            assertFalse { M >= L }
        }
    }

}