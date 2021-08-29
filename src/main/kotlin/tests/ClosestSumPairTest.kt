package tests

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import problems.ClosestSumPair

class ClosestSumPairTest {
    @Test
    fun test1() {
        val closestSumPair = ClosestSumPair()
        val a1 = intArrayOf(-1,3,8,2,9,5)
        val a2 = intArrayOf(4,1,2,10,5,20)
        val target = 24
        val result = closestSumPair.find(a1,a2,target)
        assertThat(result, anyOf(equalTo(Pair(3,20)), equalTo(Pair(5,20))))
    }
    @Test
    fun test2() {
        val closestSumPair = ClosestSumPair()
        val a1 = intArrayOf(19, 14, 6, 11, -16, 14, -16, -9, 16, 13)
        val a2 = intArrayOf(13, 9, -15, -2, -18, 16, 17, 2, -11, -7)
        val target = -15
        val result = closestSumPair.find(a1,a2,target)
        assertThat(result, anyOf(equalTo(Pair(-16,2)), equalTo(Pair(-9,-7))))
    }
    @Test
    fun test3() {
        val closestSumPair = ClosestSumPair()
        val a1 = intArrayOf(7, 4, 1, 10)
        val a2 = intArrayOf(4, 5, 8, 7)
        val target = 14
        val result = closestSumPair.find(a1,a2,target)
        assertThat(result, anyOf(equalTo(Pair(4,8)), equalTo(Pair(7,7)),equalTo(Pair(7,5)),equalTo(Pair(10,4)) ))
    }
}