package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
class RemoveDuplicatesFromSortedArray2 {

    fun removeDuplicates(nums: IntArray): Int {
        var current = nums[0]
        var currentCounter = 0
        var index = 0
        var removed = 0
        while ((index + removed) < nums.size) {
            var remove = false
            if (nums[index] == current) {
                currentCounter++
                remove = currentCounter > 2
            } else {
                current = nums[index]
                currentCounter = 1
            }
            if (remove) {
                for (i in index..nums.size - 2) {
                    nums[i] = nums[i + 1]
                }
                removed++
            } else {
                index++
            }
        }
        return index
    }

    fun removeDuplicates2(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            if (result == 0 || result == 1 || nums[result - 2] != num) {
                nums[result] = num
                result++
            }
        }
        return result
    }

}

class RemoveDuplicatesFromSortedArray2Test {

    private val instance = RemoveDuplicatesFromSortedArray2()

    @Test
    fun test1() {
        val result = instance.removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3))
        assertEquals(5, result)
    }

    @Test
    fun test2() {
        val result = instance.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3))
        assertEquals(7, result)
    }

}