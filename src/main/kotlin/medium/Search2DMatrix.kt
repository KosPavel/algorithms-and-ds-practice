package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/search-a-2d-matrix/
class Search2DMatrix {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val imax = matrix[0].size - 1
        for (row in matrix) {
            if (target > row[imax]) continue
            if (target >= row[0]) {
                for (el in row) {
                    if (el == target) {
                        return true
                    }
                    if (el > target) {
                        return false
                    }
                }
            }
        }
        return false
    }

}

class Search2DMatrixTest {

    private val instance = Search2DMatrix()

    @Test
    fun test1() {
        val matrix = arrayOf(
            intArrayOf(1,3,5,7),
            intArrayOf(10,11,16,20),
            intArrayOf(23,30,34,60)
        )
        val target = 3
        val expectedResult = true
        assertEquals(expectedResult, instance.searchMatrix(matrix, target))
    }

    @Test
    fun test2() {
        val matrix = arrayOf(
            intArrayOf(1,3,5,7),
            intArrayOf(10,11,16,20),
            intArrayOf(23,30,34,60)
        )
        val target = 13
        val expectedResult = false
        assertEquals(expectedResult, instance.searchMatrix(matrix, target))
    }

}