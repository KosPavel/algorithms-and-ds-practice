import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/search-insert-position/
class SearchInsertPosition {

    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.isEmpty() || target < nums.first()) return 0
        if (target > nums.last()) return nums.size
        var leftIndex = 0
        var rightIndex = nums.size
        var returnIndex: Int
        while (true) {
            if (leftIndex > rightIndex) {
                returnIndex = leftIndex
                break
            }
            returnIndex = (leftIndex + rightIndex) / 2
            if (nums[returnIndex] == target) break
            if (nums[returnIndex] < target) {
                leftIndex = returnIndex + 1
            }
            if (nums[returnIndex] > target) {
                rightIndex = returnIndex - 1
            }
        }
        return returnIndex
    }

}

class SearchInsertPositionTest {

    private val searchInsertPosition = SearchInsertPosition()

    @Test
    fun searchInsertTest() {
        val startTime = System.currentTimeMillis()
        assertEquals(2, searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 5))
        assertEquals(1, searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 2))
        assertEquals(4, searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 7))
        assertEquals(0, searchInsertPosition.searchInsert(intArrayOf(1, 3, 5, 6), 0))
        assertEquals(0, searchInsertPosition.searchInsert(intArrayOf(1), 0))
        assertEquals(1, searchInsertPosition.searchInsert(intArrayOf(1, 3), 2))
        val deltaTime = System.currentTimeMillis() - startTime
        println("My impl duration = $deltaTime")
    }

}