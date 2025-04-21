package easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/valid-palindrome/description/
class ValidPalindrome {

    fun isPalindrome(s: String): Boolean {
        val input = s.lowercase()
        var start = 0
        var end = input.length - 1
        while (start < end) {
            val startLetter = input[start]
            val endLetter = input[end]
            if (!startLetter.isLetterOrDigit()) {
                start++
            } else if (!endLetter.isLetterOrDigit()) {
                end--
            } else {
                if (startLetter != endLetter) {
                    return false
                }
                start++
                end--
            }
        }
        return true
    }

}

class ValidPalindromeTest {

    private val instance = ValidPalindrome()

    @Test
    fun test1() {
        assertEquals(true, instance.isPalindrome("A man, a plan, a canal: Panama"))
    }

    @Test
    fun test2() {
        assertEquals(false, instance.isPalindrome("race a car"))
    }

    @Test
    fun test3() {
        assertEquals(true, instance.isPalindrome(" "))
    }

}