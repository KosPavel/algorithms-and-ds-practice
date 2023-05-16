package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/find-peak-element/
class PeakIndexOfMountainArray {

    fun peakIndexInMountainArray(arr: IntArray): Int {
        for (i in 0..arr.size-1) {
            val el = arr[i]
            val nextIndex = i + 1
            if (nextIndex > arr.size - 1) return i
            if (el > arr[nextIndex]) return i
        }
        return 0
    }

}

class PeakIndexOfMountainArrayTest {

    private val instance = PeakIndexOfMountainArray()

    @Test
    fun test1() {
        val result = instance.peakIndexInMountainArray(intArrayOf(0, 1, 0))
        assertEquals(1, result)
    }

    @Test
    fun test2() {
        val result = instance.peakIndexInMountainArray(intArrayOf(0, 2, 1, 0))
        assertEquals(1, result)
    }

    @Test
    fun test3() {
        val result = instance.peakIndexInMountainArray(intArrayOf(0, 10, 5, 2))
        assertEquals(1, result)
    }

}