package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/find-peak-element/
class FindDuplicateNumber {

    fun findDuplicate(nums: IntArray): Int {
        var slow = 0
        var fast = 0
        do {
            slow = nums[slow]
            fast = nums[nums[fast]]
        } while (slow != fast)

        slow = 0
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[fast]
        }
        return slow
    }

}

class FindDuplicateNumberTest {

    private val instance = FindDuplicateNumber()

    @Test
    fun test1() {
        val result = instance.findDuplicate(intArrayOf(1, 3, 4, 2, 2))
        assertEquals(2, result)
    }

    @Test
    fun test2() {
        val result = instance.findDuplicate(intArrayOf(3, 1, 3, 4, 2))
        assertEquals(3, result)
    }

}