package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/find-peak-element/
class FindPeakElement {

    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0
        for (i in 0..nums.size-1) {
            val el = nums[i]
            val leftIndex = i - 1
            val rightIndex = i + 1
            when {
                leftIndex >= 0 && rightIndex <= nums.size - 1 -> {
                    if (el > nums[leftIndex] && el > nums[rightIndex]) {
                        return i
                    }
                }
                leftIndex < 0 -> {
                    if (el > nums[rightIndex]) {
                        return i
                    }
                }
                rightIndex > nums.size - 1 -> {
                    if (el > nums[leftIndex]) {
                        return i
                    }
                }
            }
        }
        return 0
    }

}

class FindPeakElementTest {

    private val instance = FindPeakElement()

    @Test
    fun test1() {
        val result = instance.findPeakElement(intArrayOf(1, 2, 3, 1))
        assertEquals(2, result)
    }

    @Test
    fun test2() {
        val result = instance.findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6))
        assertEquals(1, result)
    }

}