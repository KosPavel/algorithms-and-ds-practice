package easy

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
class DisappearedNumbers {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        return (IntRange(1, nums.size).toSet() - nums.toSet()).toList()
    }

}

class DisappearedNumbersTest {

    private val disappearedNumbers = DisappearedNumbers()

    @Test
    fun test1() {
        val input = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
        val expected = listOf(5, 6)
        disappearedNumbers.findDisappearedNumbers(input)
        assertContentEquals(
            expected,
            disappearedNumbers.findDisappearedNumbers(input)
        )
    }

    @Test
    fun test2() {
        val input = intArrayOf(1, 1)
        val expected = listOf(2)
        disappearedNumbers.findDisappearedNumbers(input)
        assertContentEquals(
            expected,
            disappearedNumbers.findDisappearedNumbers(input)
        )
    }

}