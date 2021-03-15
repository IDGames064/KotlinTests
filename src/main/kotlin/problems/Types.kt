package problems

typealias IntArray2D = Array<Array<Int>>
fun IntArray2D.copy() = Array(size) { get(it).clone() }
fun IntArray2D.print() = this.forEach { println(it.joinToString() ) }