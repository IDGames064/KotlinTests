package tests

import org.junit.Assert
import org.junit.Test
import problems.SumOfTwo
import kotlin.test.assertEquals

class SumOfTwoTest {
    @Test
    fun test1() {
        val result = SumOfTwo().find(arrayOf(1,2,3,5), 8)
        Assert.assertArrayEquals(result, arrayOf(2,3))
    }

    @Test
    fun test2() {
        val result = SumOfTwo().find(arrayOf(2,7,11,15), 22)
        Assert.assertArrayEquals(result, arrayOf(1,3))
    }

    @Test
    fun test3() {
        val result = SumOfTwo().find(arrayOf(0,5,100,10), 100)
        Assert.assertArrayEquals(result, arrayOf(0,2))
    }

    @Test
    fun test4() {
        val result = SumOfTwo().find(arrayOf(11,15,17,1), 22)
        Assert.assertArrayEquals(result, arrayOf())
    }

    @Test
    fun test5() {
        val result = SumOfTwo().find(arrayOf(5,50,12,4), 38)
        Assert.assertArrayEquals(result, arrayOf())
    }
}