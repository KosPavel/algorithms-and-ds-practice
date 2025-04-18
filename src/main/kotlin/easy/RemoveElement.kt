package easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

//https://leetcode.com/problems/remove-element/description/
class RemoveElement {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        for (i in 0 until nums.size) {
            if (nums[i] != `val`) {
                nums[index] = nums[i]
                index++
            }
        }
        return index
    }

}

class RemoveElementTest {

    private val instance = RemoveElement()

    @Test
    fun test1() {
        val input1 = intArrayOf(3, 2, 2, 3)
        val input2 = 3
        val expectedOutput = 2
        val result = instance.removeElement(input1, input2)
        assertEquals(expectedOutput, result)
    }

    @Test
    fun test2() {
        val input1 = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
        val input2 = 2
        val expectedOutput = 5
        val result = instance.removeElement(input1, input2)
        assertEquals(expectedOutput, result)
    }

}