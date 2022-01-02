package easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/binary-search/
class BinarySearch {

    fun search(nums: IntArray, target: Int): Int {
        var leftIndex = 0
        var rightIndex = nums.size - 1
        var returnIndex = -1
        while (true) {
            if (leftIndex > rightIndex) {
                returnIndex = -1
                break
            }
            val middle = (leftIndex + rightIndex) / 2
            if (nums[middle] == target) {
                returnIndex = middle
                break
            }
            if (nums[middle] < target) {
                leftIndex = middle + 1
            }
            if (nums[middle] > target) {
                rightIndex = middle - 1
            }
        }
        return returnIndex
    }

    fun searchKotlin(nums: IntArray, target: Int): Int = nums.indexOf(target)

}

class BinarySearchTest {

    private val binarySearch = BinarySearch()

    @Test
    fun searchTest() {
        val startTime = System.currentTimeMillis()
        assertEquals(4, binarySearch.search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
        assertEquals(-1, binarySearch.search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
        val deltaTime = System.currentTimeMillis() - startTime
        println("My impl duration = $deltaTime")
    }

    @Test
    fun searchKotlinTest() {
        val startTime = System.currentTimeMillis()
        assertEquals(4, binarySearch.searchKotlin(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
        assertEquals(-1, binarySearch.searchKotlin(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
        val deltaTime = System.currentTimeMillis() - startTime
        println("Kotlin impl duration = $deltaTime")
    }

}