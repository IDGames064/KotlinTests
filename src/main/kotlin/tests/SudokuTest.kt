package tests

import org.junit.Test
import problems.Sudoku

class SudokuTest {
    @Test
    fun test1() {
        val result = Sudoku().solve(arrayOf(arrayOf(5,3,0, 0,7,0, 0,0,0),
                                            arrayOf(6,0,0, 1,9,5, 0,0,0),
                                            arrayOf(0,9,8, 0,0,0, 0,6,0),

                                            arrayOf(8,0,0, 0,6,0, 0,0,3),
                                            arrayOf(4,0,0, 8,0,3, 0,0,1),
                                            arrayOf(7,0,0, 0,2,0, 0,0,6),

                                            arrayOf(0,6,0, 0,0,0, 2,8,0),
                                            arrayOf(0,0,0, 4,1,9, 0,0,5),
                                            arrayOf(0,0,0, 0,8,0, 0,7,9)))
        println(result.contentDeepToString().replace("[","").replace("], ", "\n").replace("]",""))
    }
    @Test
    fun test2() {
        val result = Sudoku().solve(arrayOf(arrayOf(0,0,0, 0,0,6, 8,0,0),
                                            arrayOf(0,6,0, 0,0,0, 0,4,0),
                                            arrayOf(8,0,9, 0,0,0, 0,5,0),

                                            arrayOf(0,0,0, 8,0,0, 0,0,2),
                                            arrayOf(1,0,6, 3,0,0, 0,0,0),
                                            arrayOf(0,0,0, 0,2,0, 7,0,0),

                                            arrayOf(0,0,8, 0,0,0, 0,1,0),
                                            arrayOf(9,0,0, 0,0,0, 0,0,7),
                                            arrayOf(0,4,5, 9,0,0, 0,8,0)))
        println(result.contentDeepToString().replace("[","").replace("], ", "\n").replace("]",""))
    }
    @Test
    fun test3() {
        val result = Sudoku().solve(arrayOf(arrayOf(8,0,0, 0,0,0, 0,0,0),
                                            arrayOf(0,0,3, 6,0,0, 0,0,0),
                                            arrayOf(0,7,0, 0,9,0, 2,0,0),

                                            arrayOf(0,5,0, 0,0,7, 0,0,0),
                                            arrayOf(0,0,0, 0,4,5, 7,0,0),
                                            arrayOf(0,0,0, 1,0,0, 0,3,0),

                                            arrayOf(0,0,1, 0,0,0, 0,6,8),
                                            arrayOf(0,0,8, 5,0,0, 0,1,0),
                                            arrayOf(0,9,0, 0,0,0, 4,0,0)))
        println(result.contentDeepToString().replace("[","").replace("], ", "\n").replace("]",""))
    }
}