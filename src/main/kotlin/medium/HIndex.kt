package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/h-index/description/
class HIndex {

    fun hIndex(citations: IntArray): Int {
        var maxCitations = 0
        citations.forEach {
            if (it > maxCitations) {
                maxCitations = it
            }
        }
        val hIndexArray = IntArray(maxCitations + 1) { 0 }
        citations.forEach { paperCitations ->
            var hIndex = paperCitations
            while (hIndex >= 0) {
                hIndexArray[hIndex] = hIndexArray[hIndex] + 1
                hIndex--
            }
        }
        var hIndex = hIndexArray.size - 1
        while (hIndex >= 0) {
            if (hIndex <= hIndexArray[hIndex]) return hIndex
            hIndex--
        }
        return 0
    }

}

class HIndexTest {

    private val instance = HIndex()

    @Test
    fun test1() {
        assertEquals(3, instance.hIndex(intArrayOf(3, 0, 6, 1, 5)))
    }

    @Test
    fun test2() {
        assertEquals(1, instance.hIndex(intArrayOf(1, 3, 1)))
    }

}
