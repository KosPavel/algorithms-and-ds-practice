package medium

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/longest-palindromic-substring/
class LongestPalindromicSubstring {

    fun longestPalindrome(s: String): String {
        if (s.length == 1) return s
        var start = 0
        var end = 0
        for (i in s.indices) {
            val even = findPalindromeIndexes(s, i, i)
            val odd = findPalindromeIndexes(s, i, i + 1)
            val res = if ((even.second - even.first) > (odd.second - odd.first)) even else odd
            if ((res.second - res.first) > (end - start)) {
                start = res.first
                end = res.second
            }
        }
        return s.slice(start..end)
    }

    private fun findPalindromeIndexes(string: String, s: Int, e: Int): Pair<Int, Int> {
        var start = s
        var end = e
        while (start >= 0 && end < string.length) {
            if (string[start] == string[end]) {
                start--
                end++
            } else {
                break
            }
        }
        return Pair(start + 1, end - 1)
    }

}

class LongestPalindromicSubstringTest {

    private val instance = LongestPalindromicSubstring()

    @Test
    fun test1() {
        assertEquals("bab", instance.longestPalindrome("babad"))
    }

    @Test
    fun test2() {
        assertEquals("bb", instance.longestPalindrome("cbbd"))
    }

    @Test
    fun test3() {
        assertEquals("a", instance.longestPalindrome("ac"))
    }

    @Test
    fun test4() {
        assertEquals("aca", instance.longestPalindrome("aacabdkacaa"))
    }

    @Test
    fun test5() {
        assertEquals("ccc", instance.longestPalindrome("ccc"))
    }

}