package problems

class SumOfTwo {
    fun find(array: Array<Int>, target: Int): Array<Int> {
        val lookup = HashMap<Int,Int>()
        for (i in array.indices) {
            val diff = target - array[i]
            lookup[diff]?.let {
                return arrayOf(it, i)
            }
            lookup[array[i]] = i
        }
        return arrayOf()
    }
}