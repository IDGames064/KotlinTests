package algos

fun <T> List<Pair<T, T>>.getUniqueValuesFromPairs(): Set<T> = this
    .map { (a, b) -> listOf(a, b) }
    .flatten()
    .toSet()

fun <T> List<Pair<T, T>>.getUniqueValuesFromPairs(predicate: (T) -> Boolean): Set<T> = this
    .map { (a, b) -> listOf(a, b) }
    .flatten()
    .filter(predicate)
    .toSet()

data class Graph<T>(
    val vertices: Set<T>,
    val edges: Map<T, Set<T>>,
    val weights: Map<Pair<T, T>, Int>
) {
    constructor(weights: Map<Pair<T, T>, Int>): this(
        vertices = weights.keys.toList().getUniqueValuesFromPairs(),
        edges = weights.keys
            .groupBy { it.first }
            .mapValues { it.value.getUniqueValuesFromPairs { x -> x !== it.key } }
            .withDefault { emptySet() },
        weights = weights
    )
}

fun <T> Dijkstra(graph: Graph<T>, start: T): Map<T, T?> {

    val S: MutableSet<T> = mutableSetOf()
    val delta = graph.vertices.map { it to Int.MAX_VALUE }.toMap().toMutableMap()
    delta[start] = 0
    val previous: MutableMap<T, T?> = graph.vertices.map { it to null }.toMap().toMutableMap()


    while (S != graph.vertices) {
        val v: T = delta
            .filter { !S.contains(it.key) }
            .minByOrNull { it.value }!!
            .key
        graph.edges.getValue(v).minus(S).forEach { neighbor ->
            val newPath = delta.getValue(v) + graph.weights.getValue(Pair(v, neighbor))
            if (newPath < delta.getValue(neighbor)) {
                delta[neighbor] = newPath
                previous[neighbor] = v
            }
        }
        S.add(v)
    }
    return previous.toMap()
}

fun <T> BellmanFord(graph: Graph<T>, start: T): Map<T, T?> {
    val delta = graph.vertices.map { it to Int.MAX_VALUE }.toMap().toMutableMap()
    val previous: MutableMap<T, T?> = graph.vertices.map { it to null }.toMap().toMutableMap()
    delta[start] = 0
    repeat (graph.vertices.size) {
        //println(delta)
        for (edge in graph.weights) {
            val newPath = delta.getValue(edge.key.first) + edge.value
            if (delta.getValue(edge.key.first) != Int.MAX_VALUE && newPath < delta.getValue(edge.key.second)) {
                delta[edge.key.second] = newPath
                previous[edge.key.second] = edge.key.first
            }
        }
    }

    return previous.toMap()
}



fun <T> shortestPath(shortestPathTree: Map<T, T?>, start: T, end: T): List<T> {
    fun pathTo(start: T, end: T): List<T> {
        if (shortestPathTree[end] == null) return listOf(end)
        return listOf(pathTo(start, shortestPathTree[end]!!), listOf(end)).flatten()
    }

    return pathTo(start, end)
}