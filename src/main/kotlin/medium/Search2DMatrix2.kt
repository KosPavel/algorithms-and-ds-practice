package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/search-a-2d-matrix-ii/
class Search2DMatrix2 {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix[0].size - 1
        val n = matrix.size - 1
        var i = m
        var j = 0
        while (i >= 0 && j <= n) {
            val current = matrix[j][i]
            if (current == target) {
                return true
            }
            if (current > target) {
                i--
            } else {
                j++
            }
        }
        return false
    }

}

class Search2DMatrix2Test {

    private val instance = Search2DMatrix2()

    @Test
    fun test1() {
        val matrix = arrayOf(
            intArrayOf(1, 4, 7, 11, 15),
            intArrayOf(2, 5, 8, 12, 19),
            intArrayOf(3, 6, 9, 16, 22),
            intArrayOf(10, 13, 14, 17, 24),
            intArrayOf(18, 21, 23, 26, 30)
        )
        val target = 5
        val expectedResult = true
        assertEquals(expectedResult, instance.searchMatrix(matrix, target))
    }

    @Test
    fun test2() {
        val matrix = arrayOf(
            intArrayOf(1, 4, 7, 11, 15),
            intArrayOf(2, 5, 8, 12, 19),
            intArrayOf(3, 6, 9, 16, 22),
            intArrayOf(10, 13, 14, 17, 24),
            intArrayOf(18, 21, 23, 26, 30)
        )
        val target = 20
        val expectedResult = false
        assertEquals(expectedResult, instance.searchMatrix(matrix, target))
    }

    @Test
    fun test3() {
        val matrix = arrayOf(
            intArrayOf(-5)
        )
        val target = -5
        val expectedResult = true
        assertEquals(expectedResult, instance.searchMatrix(matrix, target))
    }

}