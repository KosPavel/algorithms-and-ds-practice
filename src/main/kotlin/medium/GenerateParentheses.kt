package medium

import org.junit.jupiter.api.Test

// https://leetcode.com/problems/generate-parentheses/description/
class GenerateParentheses {

    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        calculateParenthesis("", n, n, result)
        return result
    }

    private fun calculateParenthesis(
        current: String,
        numberOfOpenBracketsLeft: Int,
        numberOfCloseBracketsLeft: Int,
        result: MutableList<String>,
    ) {
        if (numberOfOpenBracketsLeft > numberOfCloseBracketsLeft) return
        if (numberOfOpenBracketsLeft == 0 && numberOfCloseBracketsLeft == 0) {
            result.add(current)
            return
        }
        if (numberOfOpenBracketsLeft > 0) {
            calculateParenthesis(current + "(", numberOfOpenBracketsLeft - 1, numberOfCloseBracketsLeft, result)
        }
        if (numberOfCloseBracketsLeft > 0) {
            calculateParenthesis(current + ")", numberOfOpenBracketsLeft, numberOfCloseBracketsLeft - 1, result)
        }
    }

}

class GenerateParenthesesTest {

    private val instance = GenerateParentheses()

    @Test
    fun test1() {
        val expectedResult = listOf("((()))", "(()())", "(())()", "()(())", "()()()")
        val actualResult = instance.generateParenthesis(3)
        println("Expected: $expectedResult\nActual: $actualResult")
        assert(expectedResult.all { it in actualResult } && actualResult.all { it in expectedResult })
    }

    @Test
    fun test2() {
        val expectedResult = listOf("()")
        val actualResult = instance.generateParenthesis(1)
        println("Expected: $expectedResult\nActual: $actualResult")
        assert(expectedResult.all { it in actualResult } && actualResult.all { it in expectedResult })
    }

}
