package problems

class ValidSubsequence {
    fun execute(array: List<Int>, sequence: List<Int>): Boolean {
        var currentIndex = 0
        array.forEach {
            if (it == sequence[currentIndex] && ++currentIndex == sequence.size) return true
        }
        return false
    }
}