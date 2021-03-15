package tests

import org.junit.Assert.*
import org.junit.Test
import problems.LinkedList

class ShiftLinkedListTest {
    @Test
    fun test1() {
        val linkedList = LinkedList(listOf(0,1,2,3,4,5))
        linkedList.shift(2)
        assertEquals(listOf(4,5,0,1,2,3), linkedList.toList())
    }
    @Test
    fun test2() {
        val linkedList = LinkedList(listOf(0,1,2,3,4,5))
        linkedList.shift(-2)
        assertEquals(listOf(2,3,4,5,0,1), linkedList.toList())
    }
    @Test
    fun test3() {
        val linkedList = LinkedList(listOf(0))
        linkedList.shift(10)
        assertEquals(listOf(0), linkedList.toList())
    }
    @Test
    fun test4() {
        val linkedList = LinkedList(listOf(0,1,2,3,4,5))
        linkedList.shift(-36)
        assertEquals(listOf(0,1,2,3,4,5), linkedList.toList())
    }
}