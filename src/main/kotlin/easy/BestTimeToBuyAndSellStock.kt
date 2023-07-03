package easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class BestTimeToBuyAndSellStock {

    fun maxProfit(prices: IntArray): Int {
        var min = prices[0]
        var profit = 0
        prices.forEach {
            if (it < min) min = it
            profit = maxOf(profit, it - min)
        }
        return profit
    }

}

class BestTimeToBuyAndSellStockTest {

    private val instance = BestTimeToBuyAndSellStock()

    @Test
    fun test1() {
        assertEquals(5, instance.maxProfit(intArrayOf(7,1,5,3,6,4)))
    }

    @Test
    fun test2() {
        assertEquals(0, instance.maxProfit(intArrayOf(7,6,4,3,1)))
    }

}