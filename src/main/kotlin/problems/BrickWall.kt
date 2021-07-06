package problems

import kotlin.math.max

class BrickWall {
    fun findLeastIntersections(wall: IntArray2D): Int {
        val numJoints = HashMap<Int,Int>()
        var max = 0
        wall.forEach { row ->
          var currentLength = 0
          for (i in 0 until row.size-1) {
              currentLength += row[i]
              numJoints[currentLength] = if (numJoints.containsKey(currentLength)) numJoints[currentLength]!! + 1 else 1
              max = max(numJoints[currentLength]!!, max)
          }
        }
        return wall.size - max
    }
}