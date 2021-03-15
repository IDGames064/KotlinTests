package tests

import org.junit.Assert.*
import org.junit.Test
import problems.IslandCounter

class IslandCounterTest {
    @Test
    fun test1() {
        val matrix = arrayOf(arrayOf(1,1,0,0,1),arrayOf(1,1,0,0,0),arrayOf(1,1,1,0,0),arrayOf(0,0,0,0,1),arrayOf(0,0,1,1,1))
        val result = IslandCounter().getCount(matrix)
        assertEquals(3, result)
    }
    @Test
    fun test2() {
        val matrix = arrayOf(arrayOf(1,0,1,0,1,0,1,0,1))
        val result = IslandCounter().getCount(matrix)
        assertEquals(5, result)
    }
    @Test
    fun test3() {
        val matrix = arrayOf(arrayOf(1,1),arrayOf(1,1))
        val result = IslandCounter().getCount(matrix)
        assertEquals(1, result)
    }
    @Test
    fun test4() {
        val matrix = arrayOf(arrayOf(0))
        val result = IslandCounter().getCount(matrix)
        assertEquals(0, result)
    }
}