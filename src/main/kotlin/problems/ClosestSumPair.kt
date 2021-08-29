package problems


class ClosestSumPair {
    fun find(a1: IntArray, a2: IntArray, target: Int): Pair<Int, Int> {

        fun findClosest(a: IntArray, value: Int): Int {
            var index = 0
            var end = a.size - 1
            var center = 0
            while (index <= end) {
                center = (end+index) / 2
                if (value == a[center]) return value
                else if (value < a[center]) end = center-1
                else if (value > a[center]) index = center+1
            }
            return a[center]
        }

        var closestPair: Pair<Int, Int> = Pair(0,0)
        var closestOverall = Int.MAX_VALUE
        val a1sorted = a1.copyOf().sorted().toIntArray()

        a2.forEach {
            val closestFound = findClosest(a1sorted, target-it)
            val closest = kotlin.math.abs(closestFound+it-target)
            if (closest < closestOverall) {
                closestOverall = closest
                closestPair = Pair(closestFound, it)
            }
        }

        return closestPair
    }
}