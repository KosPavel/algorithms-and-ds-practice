import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

//https://leetcode.com/problems/search-insert-position/
class TwoSum2 {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.size - 1
        while (i < j) {
            val required = target - numbers[i]
            if (numbers[j] == required) return intArrayOf(i + 1, j + 1)
            if (numbers[j] > required) j-- else i++
        }
        return intArrayOf()
    }

}

class TwoSum2Test {

    private val twoSum2 = TwoSum2()

    @Test
    fun searchInsertTest1() {
        assertContentEquals(intArrayOf(1, 2), twoSum2.twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun searchInsertTest2() {
        assertContentEquals(intArrayOf(1, 3), twoSum2.twoSum(intArrayOf(2, 3, 4), 6))
    }

    @Test
    fun searchInsertTest3() {
        assertContentEquals(intArrayOf(1, 2), twoSum2.twoSum(intArrayOf(-1, 0), -1))
    }

}