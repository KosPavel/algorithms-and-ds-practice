package hard

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/shortest-palindrome/
class ShortestPalindrome {

    fun shortestPalindrome(s: String): String {
        if (s.length == 1) return s
        var firstNotEpsentCharIndex = s.length - 1
        var start = 0
        var end = firstNotEpsentCharIndex
        while (start < end) {
            if (s[start] != s[end]) {
                firstNotEpsentCharIndex--
                start = 0
                end = firstNotEpsentCharIndex
            } else {
                start++
                end--
            }
        }
        firstNotEpsentCharIndex++
        var prefix = ""
        while (firstNotEpsentCharIndex <= s.length - 1) {
            prefix = "${s[firstNotEpsentCharIndex]}$prefix"
            firstNotEpsentCharIndex++
        }
        return "$prefix$s"
    }

}

class ShortestPalindromeTest {

    private val instance = ShortestPalindrome()

    @Test
    fun test1() {
        assertEquals("aaacecaaa", instance.shortestPalindrome("aacecaaa"))
    }

    @Test
    fun test2() {
        assertEquals("dcbabcd", instance.shortestPalindrome("abcd"))
    }

    @Test
    fun test3() {
        assertEquals("a", instance.shortestPalindrome("a"))
    }

    @Test
    fun test4() {
        assertEquals("aba", instance.shortestPalindrome("aba"))
    }

    @Test
    fun test5() {
        assertEquals("bbabb", instance.shortestPalindrome("abb"))
    }

    @Test
    fun test6() {
        assertEquals("daabbaad", instance.shortestPalindrome("aabbaad"))
    }

}