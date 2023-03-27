package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
class LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        println(s.toSet())
        var uniqueLength = 0
        var i = 0
        var j = 1
        while (j <= s.length) {
            if (s.substring(i, j).isUniqueSymbols()) {
                if ((j - i) > uniqueLength) {
                    uniqueLength = j - i
                }
            } else {
                i++
            }
            j++
        }
        return uniqueLength
    }

    private fun String.isUniqueSymbols(): Boolean {
        return this.length == this.toSet().size
    }

}

class LongestSubstringWithoutRepeatingCharactersTest {

    private val instance = LongestSubstringWithoutRepeatingCharacters()

    @Test
    fun searchInsertTest1() {
        assertEquals(3, instance.lengthOfLongestSubstring("abcabcbb"))
    }

    @Test
    fun searchInsertTest2() {
        assertEquals(1, instance.lengthOfLongestSubstring("bbbbb"))
    }

    @Test
    fun searchInsertTest3() {
        assertEquals(3, instance.lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun searchInsertTest4() {
        assertEquals(0, instance.lengthOfLongestSubstring(""))
    }

    @Test
    fun searchInsertTest5() {
        assertEquals(1, instance.lengthOfLongestSubstring(" "))
    }

}