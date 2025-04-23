package easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/climbing-stairs/description/
class ClimbingStairs {

    fun climbStairs(n: Int): Int {
        return climb(n)
    }

    private fun climb(n: Int): Int {
        val memo = IntArray(n + 1) { -1 }
        return climbMemo(n, memo)
    }

    private fun climbMemo(stepsLeft: Int, memo: IntArray): Int {
        if (stepsLeft == 0) return 1
        if (stepsLeft < 0) return 0
        if (memo[stepsLeft] != -1) return memo[stepsLeft]

        memo[stepsLeft] = climbMemo(stepsLeft - 1, memo) + climbMemo(stepsLeft - 2, memo)
        return memo[stepsLeft]
    }

}

class ClimbingStairsTest {

    private val instance = ClimbingStairs()

    @Test
    fun test1() {
        assertEquals(2, instance.climbStairs(2))
    }

    @Test
    fun test2() {
        assertEquals(3, instance.climbStairs(3))
    }

}