fun main() {
    val weights = mapOf(
        Pair("A", "B") to 2,
        Pair("A", "C") to 8,
        Pair("A", "D") to 5,
        Pair("B", "C") to 1,
        Pair("C", "E") to 3,
        Pair("D", "E") to 2
    )

    val weights2 = mapOf(
        Pair("A", "B") to 10,
        Pair("A", "C") to 3,
        Pair("B", "C") to 1,
        Pair("C", "B") to 4,
        Pair("B", "D") to 2,
        Pair("C", "D") to 8,
        Pair("D", "E") to 7,
        Pair("E", "D") to 9,
        Pair("C", "E") to 2,
    )

    val weights3 = mapOf(
        Pair("A", "B") to 2,
        Pair("B", "C") to 2,
        Pair("A", "C") to 3,
        Pair("C", "D") to 3,
        Pair("D", "E") to 3,
        Pair("C", "E") to 7,
        Pair("E", "F") to 4,
        Pair("F", "G") to 4,
        Pair("E", "G") to 6,
        Pair("G", "H") to 5,
        Pair("H", "J") to 5,
        Pair("G", "J") to 11,
    )


    val start = "A"
    val shortestPathTree = Dijkstra(Graph(weights3), start)
    val shortestPathTree2 = BellmanFord(Graph(weights3), start)

    println(shortestPath(shortestPathTree, start, "J"))

    val ar = intArrayOf(125,1076,52,2,431,312,1,7235,22,100,8,144,91,1873,14)

    printResults(ar) { radixSort(it) }
}