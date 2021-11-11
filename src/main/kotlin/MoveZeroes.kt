import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

//https://leetcode.com/problems/move-zeroes/
class MoveZeroes {

    fun moveZeroes(nums: IntArray): Unit {
        if (nums.size == 1) return
        var i = 0
        var j = nums.size - 1
        while (i < j) {
            if (nums[j] == 0) {
                j--
                continue
            }
            if (nums[i] == 0) {
                while (i < j) {
                    nums[i] = nums[i + 1].also { nums[i + 1] = nums[i] }
                    i++
                }
                i = -1
            }
            i++
        }
    }

}

class MoveZeroesTest {

    private val moveZeroes = MoveZeroes()

    @Test
    fun searchInsertTest() {
        val input = intArrayOf(0, 1, 0, 3, 12)
        val expectedOutput = intArrayOf(1, 3, 12, 0, 0)
        moveZeroes.moveZeroes(input)
        assertContentEquals(
            expectedOutput,
            input
        )
    }

}