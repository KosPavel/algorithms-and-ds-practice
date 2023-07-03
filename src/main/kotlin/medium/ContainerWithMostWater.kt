package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/container-with-most-water/
class ContainerWithMostWater {

    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var area = 0
        while (l != r) {
            area = kotlin.math.max(area, kotlin.math.min(height[l], height[r]) * (r - l))
            if (height[l] > height[r]) {
                r -= 1
            } else {
                l += 1
            }
        }
        return area
    }

}

class ContainerWithMostWaterTest {

    private val instance = ContainerWithMostWater()

    @Test
    fun test1() {
        val result = instance.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
        assertEquals(49, result)
    }

    @Test
    fun test2() {
        val result = instance.maxArea(intArrayOf(1, 1))
        assertEquals(1, result)
    }

}