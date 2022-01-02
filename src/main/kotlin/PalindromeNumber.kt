import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/palindrome-number/
class PalindromeNumber {

    fun isPalindrome(x: Int): Boolean {
        return if (x < 0) false
        else {
            val nums = mutableListOf<Int>()
            var temp = x
            while (temp >= 1) {
                nums.add(temp % 10)
                temp /= 10
            }

            var l = 0
            var r = nums.size - 1
            while (l < r) {
                if (nums[l] != nums[r]) {
                    return false
                }
                r--
                l++
            }
            return true
        }
    }

    fun isPalindrome2(x: Int): Boolean {
        return if (x < 0) false
        else {
            var temp = x
            var reversedNumber = 0
            while (temp >= 1) {
                val reminder = temp % 10
                reversedNumber = reversedNumber * 10 + reminder
                temp /= 10
            }
            x == reversedNumber
        }
    }

}

class PalindromeNumberTest {

    private val palindromeNumber = PalindromeNumber()

    @Test
    fun isPalindromeTest1() {
        assertEquals(true, palindromeNumber.isPalindrome(121))
    }

    @Test
    fun isPalindromeTest2() {
        assertEquals(false, palindromeNumber.isPalindrome(-121))
    }

    @Test
    fun isPalindromeTest3() {
        assertEquals(false, palindromeNumber.isPalindrome(10))
    }

    @Test
    fun isPalindromeTest4() {
        assertEquals(true, palindromeNumber.isPalindrome2(121))
    }

    @Test
    fun isPalindromeTest5() {
        assertEquals(false, palindromeNumber.isPalindrome2(-121))
    }

    @Test
    fun isPalindromeTest6() {
        assertEquals(false, palindromeNumber.isPalindrome2(10))
    }

}