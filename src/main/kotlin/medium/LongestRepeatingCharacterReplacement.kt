package medium

import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.test.assertEquals

//https://leetcode.com/problems/longest-repeating-character-replacement/
class LongestRepeatingCharacterReplacement {

    fun characterReplacement(s: String, k: Int): Int {
        var mostFreqCharCount = 0
        var start = 0
        var max = 0
        val windowChars = mutableMapOf<Char, Int>()

        for (end in s.indices) {
            windowChars[s[end]] = windowChars.getOrDefault(s[end], 0) + 1
            mostFreqCharCount = max(windowChars[s[end]]!!, mostFreqCharCount)
            if (end - start + 1 > mostFreqCharCount + k) {
                windowChars[s[start]] = windowChars[s[start]]!! - 1
                start++
            }
            max = max(max, end - start + 1)
        }
        return max
    }

}

class LongestRepeatingCharacterReplacementTest {

    private val instance = LongestRepeatingCharacterReplacement()

    @Test
    fun test1() {
        assertEquals(4, instance.characterReplacement("ABAB", 2))
    }

    @Test
    fun test2() {
        assertEquals(4, instance.characterReplacement("AABABBA", 1))
    }

}