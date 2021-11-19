import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/permutation-in-string/
class PermutationInString {

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val s1arr = IntArray(26)
        val s2arr = IntArray(26)
        for (i in s1.indices) {
            s1arr[s1[i] - 'a']++
            s2arr[s2[i] - 'a']++
        }
        for (i in 0 until s2.length - s1.length) {
            if (matches(s1arr, s2arr)) return true
            s2arr[s2[i + s1.length] - 'a']++
            s2arr[s2[i] - 'a']--
        }
        return matches(s1arr, s2arr)
    }

    private fun matches(s1map: IntArray, s2map: IntArray): Boolean {
        for (i in 0..25) {
            if (s1map[i] != s2map[i]) return false
        }
        return true
    }

}

class PermutationInStringTest {

    private val instance = PermutationInString()

    @Test
    fun searchInsertTest1() {
        assertEquals(true, instance.checkInclusion("ab", "eidbaooo"))
    }

    @Test
    fun searchInsertTest2() {
        assertEquals(false, instance.checkInclusion("ab", "eidboaoo"))
    }

    @Test
    fun searchInsertTest3() {
        assertEquals(true, instance.checkInclusion("adc", "dcda"))
    }

    @Test
    fun searchInsertTest4() {
        assertEquals(true, instance.checkInclusion("ab", "ab"))
    }

    @Test
    fun searchInsertTest5() {
        assertEquals(true, instance.checkInclusion("abc", "bbbca"))
    }

    @Test
    fun searchInsertTest6() {
        assertEquals(false, instance.checkInclusion("hello", "ooolleoooleh"))
    }

    @Test
    fun searchInsertTest7() {
        assertEquals(true, instance.checkInclusion("aaa", "bbbaaabbb"))
    }

}