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
              numJoints[currentLength] = (numJoints[currentLength] ?: 0) + 1
              max = max(numJoints[currentLength] ?: 0, max)
          }
        }
        return wall.size - max
    }
}