import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.test.assertContentEquals

//https://leetcode.com/problems/squares-of-a-sorted-array/
class SquaresSortedArray {

    fun sortedSquares(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var left = 0
        var right = nums.size - 1
        var resultIndex = nums.size - 1
        while (left <= right) {
            val leftNum = nums[left]
            val rightNum = nums[right]
            if (abs(leftNum) > abs(rightNum)) {
                result[resultIndex] = leftNum * leftNum
                left++
            } else {
                result[resultIndex] = rightNum * rightNum
                right--
            }
            resultIndex--
        }
        return result
    }

    fun sortedSquaresKotlin(nums: IntArray): IntArray = nums.map { it * it }.sorted().toIntArray()

}

class SquaresSortedArrayTest {

    private val squaresSortedArray = SquaresSortedArray()

    @Test
    fun sortedSquaresTest() {
        val startTime = System.currentTimeMillis()
        assertContentEquals(
            intArrayOf(0, 1, 9, 16, 100),
            squaresSortedArray.sortedSquares(intArrayOf(-4, -1, 0, 3, 10))
        )
        assertContentEquals(
            intArrayOf(4, 9, 9, 49, 121),
            squaresSortedArray.sortedSquares(intArrayOf(-7, -3, 2, 3, 11))
        )
        assertContentEquals(
            intArrayOf(1, 4, 9, 25),
            squaresSortedArray.sortedSquares(intArrayOf(-5, -3, -2, -1))
        )
        val deltaTime = System.currentTimeMillis() - startTime
        println("My impl duration = $deltaTime")
    }

    @Test
    fun sortedSquaresKotlinTest() {
        val startTime = System.currentTimeMillis()
        assertContentEquals(
            intArrayOf(0, 1, 9, 16, 100),
            squaresSortedArray.sortedSquaresKotlin(intArrayOf(-4, -1, 0, 3, 10))
        )
        assertContentEquals(
            intArrayOf(4, 9, 9, 49, 121),
            squaresSortedArray.sortedSquaresKotlin(intArrayOf(-7, -3, 2, 3, 11))
        )
        assertContentEquals(
            intArrayOf(1, 4, 9, 25),
            squaresSortedArray.sortedSquaresKotlin(intArrayOf(-5, -3, -2, -1))
        )
        val deltaTime = System.currentTimeMillis() - startTime
        println("Kotlin impl duration = $deltaTime")
    }

}