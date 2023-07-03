package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/partition-labels/
class PartitionLabels {

    fun partitionLabels(s: String): List<Int> {
        val result = mutableListOf<Int>()

        val lastIndexes = IntArray(26)

        //Store the last index of every character present in String
        for (i in 0..s.lastIndex) {
            lastIndexes[s[i] - 'a'] = i
        }

        var start = 0
        var end = 0

        for (i in 0..s.lastIndex) {
            end = maxOf(end, lastIndexes[s[i] - 'a'])
            if (end == i) {
                result.add(end - start + 1)
                start = end + 1
            }
        }
        return result
    }

}

class PartitionLabelsTest {

    private val instance = PartitionLabels()

    @Test
    fun test1() {
        val result = instance.partitionLabels("ababcbacadefegdehijhklij")
        assertEquals(listOf(9, 7, 8), result)
    }

    @Test
    fun test2() {
        val result = instance.partitionLabels("eccbbbbdec")
        assertEquals(listOf(10), result)
    }

}