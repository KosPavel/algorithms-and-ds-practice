package easy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/roman-to-integer/
class RomanToInteger {

    private val converter: Map<Char, Int> = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    fun romanToInt(s: String): Int {
        val lastIndex = s.length - 1
        return s.mapIndexed { index, c ->
            val number = converter[c]!!
            if (index < lastIndex && (converter[s[index + 1]]!! > number)) {
                -number
            } else {
                number
            }
        }.sumOf { it }
    }

}

class RomanToIntegerTest {

    private val romanToInteger = RomanToInteger()

    @Test
    fun case1() {
        assertEquals(3, romanToInteger.romanToInt("III"))
    }

    @Test
    fun case2() {
        assertEquals(58, romanToInteger.romanToInt("LVIII"))
    }

    @Test
    fun case3() {
        assertEquals(1994, romanToInteger.romanToInt("MCMXCIV"))
    }

}