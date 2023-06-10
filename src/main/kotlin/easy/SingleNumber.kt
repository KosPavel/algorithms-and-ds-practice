package easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/single-number/
class SingleNumber {

    fun singleNumber(nums: IntArray): Int {
        var result = 0

        for (num in nums) {
            val numB = Integer.toBinaryString(num)
            val resB = Integer.toBinaryString(result)
            result = result.xor(num)
            val resA = Integer.toBinaryString(result)
            println("$resB ^ $numB = $resA")
        }

        return result
    }

}

class SingleNumberTest {

    private val instance = SingleNumber()

    @Test
    fun test1() {
        assertEquals(instance.singleNumber(intArrayOf(2, 2, 1)), 1)
    }

    @Test
    fun test2() {
        assertEquals(instance.singleNumber(intArrayOf(4,1,2,1,2)), 4)
    }

    @Test
    fun test3() {
        assertEquals(instance.singleNumber(intArrayOf(1)), 1)
    }

}