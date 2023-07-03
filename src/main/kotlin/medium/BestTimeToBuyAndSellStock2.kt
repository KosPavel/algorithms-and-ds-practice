package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
class BestTimeToBuyAndSellStock2 {

    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) return 0

        var profit = 0

        for (index in 0 until prices.size - 1 ) {
            if (prices[index] < prices[index + 1]) profit += (prices[index + 1] - prices[index])
        }

        return profit
    }

}

class BestTimeToBuyAndSellStock2Test {

    private val instance = BestTimeToBuyAndSellStock2()

    @Test
    fun test1() {
        assertEquals(7, instance.maxProfit(intArrayOf(7,1,5,3,6,4)))
    }

    @Test
    fun test2() {
        assertEquals(4, instance.maxProfit(intArrayOf(1,2,3,4,5)))
    }

    @Test
    fun test3() {
        assertEquals(0, instance.maxProfit(intArrayOf(7,6,4,3,1)))
    }

}