package medium

import org.junit.jupiter.api.Test

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
class LetterCombinationsOfAPhoneNumber {

    private val digitToLetters = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz",
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        return calculateCombinations(mutableListOf(), digits, 0)
    }

    private tailrec fun calculateCombinations(
        output: MutableList<String>,
        digits: String,
        currentDigitIndex: Int
    ): List<String> {
        return if (currentDigitIndex >= digits.length) {
            output
        } else {
            val letters = digitToLetters[digits[currentDigitIndex]]!!

            val newOutput = mutableListOf<String>()

            if (output.isEmpty()) {
                letters.forEach {
                    newOutput.add(it.toString())
                }
            } else {
                letters.forEach { letter ->
                    output.forEach { prev ->
                        newOutput.add(prev + letter.toString())
                    }
                }
            }
            return calculateCombinations(newOutput, digits, currentDigitIndex + 1)
        }
    }

}

class LetterCombinationsOfAPhoneNumberTest {

    private val instance = LetterCombinationsOfAPhoneNumber()

    @Test
    fun test1() {
        val expectedResult = listOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")
        val actualResult = instance.letterCombinations("23")
        println("Expected: $expectedResult\nActual: $actualResult")
        assert(expectedResult.all { it in actualResult } && actualResult.all { it in expectedResult })
    }

    @Test
    fun test2() {
        val expectedResult = listOf<String>()
        val actualResult = instance.letterCombinations("")
        println("Expected: $expectedResult\nActual: $actualResult")
        assert(expectedResult.all { it in actualResult } && actualResult.all { it in expectedResult })
    }

    @Test
    fun test3() {
        val expectedResult = listOf("a", "b", "c")
        val actualResult = instance.letterCombinations("2")
        println("Expected: $expectedResult\nActual: $actualResult")
        assert(expectedResult.all { it in actualResult } && actualResult.all { it in expectedResult })
    }

}
