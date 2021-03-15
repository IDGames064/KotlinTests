package tests

import org.junit.Assert.*
import org.junit.Test
import problems.ValidSubsequence

class ValidSubsequenceTest {
    @Test
    fun test1() {
        val result = ValidSubsequence().execute(listOf(5,1,22,25,6,-1,8,10), listOf(1,6,-1,10))
        assertEquals(true, result)
    }
    @Test
    fun test2() {
        val result = ValidSubsequence().execute(listOf(5,1,22,25,6,-1,8,10), listOf(1,6,-1,11))
        assertEquals(false, result)
    }
    @Test
    fun test3() {
        val result = ValidSubsequence().execute(listOf(1,2,3,4,5), listOf(5))
        assertEquals(true, result)
    }
    @Test
    fun test4() {
        val result = ValidSubsequence().execute(listOf(1,2,3,4,5), listOf(6))
        assertEquals(false, result)
    }
    @Test
    fun test5() {
        val result = ValidSubsequence().execute(listOf(1,2,3,4,5), listOf(1,2,3,4,5))
        assertEquals(true, result)
    }
}