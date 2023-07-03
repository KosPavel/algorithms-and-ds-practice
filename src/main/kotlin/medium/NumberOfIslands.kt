package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/number-of-islands/
class NumberOfIslands {

    fun numIslands(grid: Array<CharArray>): Int {
        var islandCount = 0
        for (row in 0..grid.lastIndex) {
            for (col in 0..grid[row].lastIndex) {
                if (grid[row][col] == '1') {
                    islandCount++
                    markIsland(row, col, grid)
                }
            }
        }
        return islandCount
    }

    private fun markIsland(row: Int, col: Int, grid: Array<CharArray>) {
        if (row >= 0 && col >= 0 && row < grid.size && col < grid[row].size && grid[row][col] == '1') {
            grid[row][col] = '0'
            markIsland(row, col + 1, grid)
            markIsland(row + 1, col, grid)
            markIsland(row, col - 1, grid)
            markIsland(row - 1, col, grid)
        }
    }

}

class NumberOfIslandsTest {

    private val instance = NumberOfIslands()

    @Test
    fun test1() {
        val grid = arrayOf(
            charArrayOf('1', '1', '1', '1', '0'),
            charArrayOf('1', '1', '0', '1', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '0', '0', '0')
        )
        assertEquals(1, instance.numIslands(grid))
    }

    @Test
    fun test2() {
        val grid = arrayOf(
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('1', '1', '0', '0', '0'),
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '0', '0', '1', '1')
        )
        assertEquals(3, instance.numIslands(grid))
    }

}
