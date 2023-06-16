package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/top-k-frequent-elements/
class TopKFrequentElements {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numsWithCounts = mutableMapOf<Int, Int>()
        nums.forEach {
            numsWithCounts[it] = (numsWithCounts[it] ?: 0) + 1
        }
        return numsWithCounts.entries.sortedByDescending { it.value }.take(k).map { it.key }.toIntArray()
    }

}

class TopKFrequentElementsTest {

    private val instance = TopKFrequentElements()

    @Test
    fun test1() {
        assertEquals(intArrayOf(1, 2).toList(), instance.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).toList())
    }

    @Test
    fun test2() {
        assertEquals(intArrayOf(1).toList(), instance.topKFrequent(intArrayOf(1), 1).toList())
    }

}
