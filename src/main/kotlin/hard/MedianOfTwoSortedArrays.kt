package hard

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/median-of-two-sorted-arrays/
class MedianOfTwoSortedArrays {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val merged = IntArray(nums1.size + nums2.size)
        val medianIndexes = getMedianIndexes(merged)
        var mergedIndex = -1
        var n1index = 0
        var n2index = 0
        while (true) {
            if (mergedIndex > medianIndexes.first && mergedIndex > (medianIndexes.second ?: 0)) {
                return if (medianIndexes.second == null) {
                    merged[medianIndexes.first].toDouble()
                } else {
                    (merged[medianIndexes.first] + merged[medianIndexes.second!!]) / 2.0
                }
            }
            mergedIndex++
            if (n1index < nums1.size && n2index < nums2.size) {
                val num1 = nums1[n1index]
                val num2 = nums2[n2index]
                if (num1 < num2) {
                    merged[mergedIndex] = num1
                    n1index++
                } else {
                    merged[mergedIndex] = num2
                    n2index++
                }
                continue
            }
            if (n1index < nums1.size) {
                merged[mergedIndex] = nums1[n1index]
                n1index++
                continue
            }
            if (n2index < nums2.size) {
                merged[mergedIndex] = nums2[n2index]
                n2index++
                continue
            }
        }
    }

    private fun getMedianIndexes(array: IntArray): Pair<Int, Int?> {
        return if (array.size % 2 != 0) {
            Pair(array.size / 2, null)
        } else {
            Pair(array.size / 2 - 1, array.size / 2)
        }
    }

}

class MedianOfTwoSortedArraysTest {

    private val instance = MedianOfTwoSortedArrays()

    @Test
    fun test1() {
        assertEquals(2.0, instance.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    }

    @Test
    fun test2() {
        assertEquals(2.5, instance.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
    }

    @Test
    fun test3() {
        assertEquals(1.0, instance.findMedianSortedArrays(intArrayOf(), intArrayOf(1)))
    }
}