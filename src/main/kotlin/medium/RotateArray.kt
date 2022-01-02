package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

//https://leetcode.com/problems/rotate-array/
class RotateArray {

    fun rotate(nums: IntArray, k: Int): Unit {
        var n = k
        while (n >= nums.size) {
            n -= nums.size
        }
        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, n - 1)
        reverse(nums, n, nums.size - 1)
    }

    private fun reverse(nums: IntArray, start: Int, end: Int) {
        var i = start
        var j = end
        while (i < j) {
            nums[i] = nums[j].also { nums[j] = nums[i] }
            i++
            j--
        }
    }

}

class RotateArrayTest {

    private val rotateArray = RotateArray()

    @Test
    fun sortedSquaresTest() {
        val input = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val expectedOutput = intArrayOf(5, 6, 7, 1, 2, 3, 4)
        rotateArray.rotate(input, 3)
        assertContentEquals(
            expectedOutput,
            input
        )
    }

    @Test
    fun sortedSquaresTest2() {
        val input = intArrayOf(-1, -100, 3, 99)
        val expectedOutput = intArrayOf(3, 99, -1, -100)
        rotateArray.rotate(input, 2)
        assertContentEquals(
            expectedOutput,
            input
        )
    }

}