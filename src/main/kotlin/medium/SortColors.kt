package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

//https://leetcode.com/problems/sort-colors/
class SortColors {

    fun sortColors(nums: IntArray): Unit {
        insertionSort(nums)
    }

    private fun insertionSort(nums: IntArray): Unit {
        for (i in 1 until nums.size) {
            val key = nums[i]
            var j = i - 1
            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j]
                j--
            }
            nums[j + 1] = key
        }
    }

}

class SortColorsTest {

    private val sortColors = SortColors()

    @Test
    fun test1() {
        val input = intArrayOf(2, 0, 2, 1, 1, 0)
        val expectedOutput = intArrayOf(0, 0, 1, 1, 2, 2)
        sortColors.sortColors(input)
        assertContentEquals(
            expectedOutput,
            input
        )
    }

    @Test
    fun test2() {
        val input = intArrayOf(2, 0, 1)
        val expectedOutput = intArrayOf(0, 1, 2)
        sortColors.sortColors(input)
        assertContentEquals(
            expectedOutput,
            input
        )
    }

}