import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

//https://leetcode.com/problems/reverse-string/
class ReverseString {

    fun reverseString(s: CharArray): Unit {
        var i = 0
        var j = s.size - 1
        while (i < j) {
            s[i] = s[j].also { s[j] = s[i] }
            i++
            j--
        }
    }

}

class ReverseStringTest {

    private val reverseString = ReverseString()

    @Test
    fun searchInsertTest1() {
        val input = charArrayOf('h', 'e', 'l', 'l', 'o')
        val expected = charArrayOf('o', 'l', 'l', 'e', 'h')
        reverseString.reverseString(input)
        assertContentEquals(
            expected,
            input
        )
    }

    @Test
    fun searchInsertTest2() {
        val input = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
        val expected = charArrayOf('h', 'a', 'n', 'n', 'a', 'H')
        reverseString.reverseString(input)
        assertContentEquals(
            expected,
            input
        )
    }

}