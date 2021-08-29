package problems

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val merged = (nums1 + nums2).sorted()
    return if (merged.size % 2 == 1) merged[merged.size / 2].toDouble() else
       (merged[merged.size / 2 - 1] + merged[merged.size / 2]) / 2.toDouble()
}