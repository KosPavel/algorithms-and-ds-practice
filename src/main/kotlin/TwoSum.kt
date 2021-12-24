import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

//https://leetcode.com/problems/two-sum/
class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray { // O(n^2)
        for ((i, iVal) in nums.withIndex()) {
            for ((j, jVal) in nums.withIndex()) {
                if (iVal + jVal == target && i != j) return intArrayOf(i, j)
            }
        }
        return intArrayOf()
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray { // O(n)
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val diff = target - nums[i]
            map[diff]?.let {
                return intArrayOf(it, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }

}

class TwoSumTest {

    private val twoSum = TwoSum()

    @Test
    fun searchInsertTest1() {
        assertContentEquals(intArrayOf(0, 1), twoSum.twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun searchInsertTest2() {
        assertContentEquals(intArrayOf(1, 2), twoSum.twoSum(intArrayOf(3, 2, 4), 6))
    }

    @Test
    fun searchInsertTest3() {
        assertContentEquals(intArrayOf(0, 1), twoSum.twoSum(intArrayOf(3, 3), 6))
    }

}