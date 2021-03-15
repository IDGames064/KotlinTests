package problems

class IslandCounter {
    fun getCount(ar: IntArray2D): Int {
        fun traverse(ar: IntArray2D, i: Int, j: Int) {
            if (i < 0 || i > ar.size - 1 || j < 0 || j > ar[i].size - 1 || ar[i][j] == 0) return
            ar[i][j] = 0
            traverse(ar, i - 1, j)
            traverse(ar, i + 1, j)
            traverse(ar, i, j - 1)
            traverse(ar, i, j + 1)
        }
        //val visited = ar.map { it.clone() }.toTypedArray()
        val visited = ar.copy()
        var result = 0

        for (i in visited.indices) {
            for (j in visited[i].indices) {
                if (visited[i][j] == 1) {
                    result++
                    traverse(visited, i, j)
                }
            }
        }
        return result
    }
    fun getSizes(ar: IntArray2D): List<Int> {
        fun traverse(ar: IntArray2D, i: Int, j: Int): Int {
            if (i < 0 || i > ar.size - 1 || j < 0 || j > ar[i].size - 1 || ar[i][j] == 0) return 0
            ar[i][j] = 0
            var result = 1
            result += traverse(ar, i - 1, j)
            result += traverse(ar, i + 1, j)
            result += traverse(ar, i, j - 1)
            result += traverse(ar, i, j + 1)
            return result
        }
        //val visited = ar.map { it.clone() }.toTypedArray()
        val visited = ar.copy()
        var result: MutableList<Int> = mutableListOf()
        for (i in visited.indices) {
            for (j in visited[i].indices) {
                if (visited[i][j] == 1) {
                    result.add(traverse(visited, i, j))
                }
            }
        }
        return result
    }
}
