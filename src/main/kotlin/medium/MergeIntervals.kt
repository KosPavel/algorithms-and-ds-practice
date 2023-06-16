package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/merge-intervals/
class MergeIntervals {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()
        intervals.forEach {
            if (result.isEmpty() || it[0] > result.last()[1]) {
                result.add(it)
            } else {
                result.last()[1] = maxOf(result.last()[1], it[1])
            }
        }
        return result.toTypedArray()
    }

}

class MergeIntervalsTest {

    private val instance = MergeIntervals()

    @Test
    fun test1() {
        val input = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
        val expected = arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18))
        assertEquals(expected.toList().map { it.toList() }, instance.merge(input).toList().map { it.toList() })
    }

    @Test
    fun test2() {
        val input = arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))
        val expected = arrayOf(intArrayOf(1, 5))
        assertEquals(expected.toList().map { it.toList() }, instance.merge(input).toList().map { it.toList() })
    }

}
