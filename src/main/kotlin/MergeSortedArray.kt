import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

//https://leetcode.com/problems/merge-sorted-array/
class MergeSortedArray {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var tail1 = m - 1
        var tail2 = n - 1
        var finishedTail = m + n - 1
        while (tail1 >= 0 && tail2 >= 0) {
            if (nums1[tail1] >= nums2[tail2]) {
                nums1[finishedTail] =  nums1[tail1]
                tail1--
            } else {
                nums1[finishedTail] = nums2[tail2]
                tail2--
            }
            finishedTail--
        }
        while (tail2 >= 0) {
            nums1[finishedTail] = nums2[tail2]
            tail2--
            finishedTail--
        }
    }

}

class MergeSortedArrayTest {

    private val mergeSortedArray = MergeSortedArray()

    @Test
    fun searchInsertTest1() {
        val nums1 = intArrayOf(1,2,3,0,0,0)
        val m = 3
        val nums2 = intArrayOf(2,5,6)
        val n = 3
        val expectedOutput = intArrayOf(1,2,2,3,5,6)
        mergeSortedArray.merge(nums1, m, nums2, n)
        assertContentEquals(
            expectedOutput,
            nums1
        )
    }

    @Test
    fun searchInsertTest2() {
        val nums1 = intArrayOf(1)
        val m = 1
        val nums2 = intArrayOf()
        val n = 0
        val expectedOutput = intArrayOf(1)
        mergeSortedArray.merge(nums1, m, nums2, n)
        assertContentEquals(
            expectedOutput,
            nums1
        )
    }

    @Test
    fun searchInsertTest3() {
        val nums1 = intArrayOf(0)
        val m = 0
        val nums2 = intArrayOf(1)
        val n = 1
        val expectedOutput = intArrayOf(1)
        mergeSortedArray.merge(nums1, m, nums2, n)
        assertContentEquals(
            expectedOutput,
            nums1
        )
    }

}