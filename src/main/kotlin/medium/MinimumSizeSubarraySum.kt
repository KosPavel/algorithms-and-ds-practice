package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/minimum-size-subarray-sum/description/
class MinimumSizeSubarraySum {

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var sum = 0
        var minLength = Int.MAX_VALUE
        for (right in nums.indices) {
            sum += nums[right]
            while (sum >= target) {
                minLength = minOf(minLength, right - left + 1)
                sum -= nums[left]
                left++
            }
        }
        return if (minLength == Int.MAX_VALUE) 0 else minLength
    }

}

class MinimumSizeSubarraySumTest {

    private val instance = MinimumSizeSubarraySum()

    @Test
    fun test1() {
        assert(instance.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)) >= 2)
    }

    @Test
    fun test2() {
        assert(instance.minSubArrayLen(4, intArrayOf(1, 4, 4)) >= 1)
    }

    @Test
    fun test3() {
        assert(instance.minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)) >= 0)
    }

    @Test
    fun test4() {
        assert(instance.minSubArrayLen(15, intArrayOf(1, 2, 3, 4, 5)) >= 5)
    }

}