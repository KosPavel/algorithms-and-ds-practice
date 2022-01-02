package easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/reverse-words-in-a-string-iii/
class ReverseWordsInString {

    fun reverseWords(s: String): String {
        return s.split(" ").joinToString(" ") {
            val array = it.toCharArray()
            var i = 0
            var j = array.size - 1
            while (i < j) {
                array[i] = array[j].also { array[j] = array[i] }
                i++
                j--
            }
            array.joinToString("")
        }
    }

}

class ReverseWordsInStringTest {

    private val reverseWordsInString = ReverseWordsInString()

    @Test
    fun searchInsertTest1() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWordsInString.reverseWords("Let's take LeetCode contest"))
    }

    @Test
    fun searchInsertTest2() {
        assertEquals("doG gniD", reverseWordsInString.reverseWords("God Ding"))
    }

}