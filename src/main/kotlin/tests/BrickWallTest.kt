package tests

import org.junit.Test
import problems.BrickWall
import kotlin.test.assertEquals

class BrickWallTest {
    @Test
    fun test1() {
        val wall = arrayOf(arrayOf(1,2,2,1),arrayOf(3,1,2),arrayOf(1,3,2),arrayOf(2,4),arrayOf(3,1,2),arrayOf(1,3,1,1))
        val result = BrickWall().findLeastIntersections(wall)
        assertEquals(result, 2)
    }
    @Test
    fun test2() {
        val wall = arrayOf(arrayOf(1),arrayOf(1),arrayOf(1))
        val result = BrickWall().findLeastIntersections(wall)
        assertEquals(result, 3)
    }
    @Test
    fun test3() {
        val wall = arrayOf(arrayOf(3,2),arrayOf(2,1,2),arrayOf(2,1,2))
        val result = BrickWall().findLeastIntersections(wall)
        assertEquals(result, 0)
    }
    @Test
    fun test4() {
        val wall = arrayOf(arrayOf(3,2),arrayOf(2,1,2),arrayOf(2,1,2), arrayOf(4,1))
        val result = BrickWall().findLeastIntersections(wall)
        assertEquals(result, 1)
    }
}