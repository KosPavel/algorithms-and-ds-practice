package easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/is-subsequence/description/
class IsSubsequence {

    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true
        var indexS = 0
        t.forEach {
            if (s[indexS] == it) {
                indexS++
            }
            if (indexS > s.lastIndex) {
                return true
            }
        }
        return false
    }

}

class IsSubsequenceTest {

    private val instance = IsSubsequence()

    @Test
    fun test1() {
        assertEquals(instance.isSubsequence("abc", "ahbgdc"), true)
    }

    @Test
    fun test2() {
        assertEquals(instance.isSubsequence("axc", "ahbgdc"), false)
    }

    @Test
    fun test3() {
        assertEquals(instance.isSubsequence("aaaaaa", "bbaaaa"), false)
    }

    @Test
    fun test4() {
        assertEquals(instance.isSubsequence("", "ahbgdc"), true)
    }

}