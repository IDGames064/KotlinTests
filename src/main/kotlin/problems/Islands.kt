package problems

typealias IntArray2D = Array<Array<Int>>
fun IntArray2D.copy() = Array(size) { get(it).clone() }
fun IntArray2D.print() = this.forEach { println(it.joinToString() ) }

class IslandCounter {
    fun execute(ar: IntArray2D): Int {
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
}
