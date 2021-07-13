package problems

class Sudoku {

    class Position(val row: Int, val col:Int)

    fun solve(board: IntArray2D): IntArray2D {

        fun findEmpty(board: IntArray2D): Position {
            for (row in board.indices) {
                for (col in board[row].indices) {
                    if (board[row][col] == 0) return Position(row, col)
                }
            }
            return Position(-1,-1)
        }

        fun checkIfValid(board: IntArray2D, pos: Position, value: Int): Boolean {
            for (row in board.indices) {
                if (board[row][pos.col] == value && row != pos.row) return false
            }
            for (col in board[pos.row].indices) {
                if (board[pos.row][col] == value && col != pos.col) return false
            }
            val startRow = pos.row / 3 * 3
            val startCol = pos.col / 3 * 3
            for (row in startRow..startRow+2) {
                for (col in startCol..startCol+2) {
                    if (board[row][col] == value && (row != pos.row || col != pos.col)) return false
                }
            }
            return true
        }

        fun nextStep(board: IntArray2D): Boolean {
            val pos = findEmpty(board)
            if (pos.col < 0) return true
            for (value in 1..9) {
                board[pos.row][pos.col] = value
                if (checkIfValid(board, pos, value)) {
                    board[pos.row][pos.col] = value
                    if (nextStep(board)) return true
                }
                board[pos.row][pos.col] = 0
            }
            return false
        }

        nextStep(board)
        return board
    }
}