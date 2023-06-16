package easy

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

//https://leetcode.com/problems/valid-parentheses/
class ValidParentheses {

    fun isValid(s: String): Boolean {
        val bracketsStack = Stack<Char>()
        for (c in s) {
            val previousBracket = try {
                bracketsStack.peek()
            } catch (e: EmptyStackException) {
                null
            }
            if (
                (previousBracket == '(' && c == ')')
                || (previousBracket == '{' && c == '}')
                || (previousBracket == '[' && c == ']')
            ) {
                bracketsStack.pop()
                continue
            }
            bracketsStack.add(c)
        }
        return bracketsStack.empty()
    }

}

class ValidParenthesesTest {

    private val instance = ValidParentheses()

    @Test
    fun test1() {
        assertEquals(true, instance.isValid("()"))
    }

    @Test
    fun test2() {
        assertEquals(true, instance.isValid("()[]{}"))
    }

    @Test
    fun test3() {
        assertEquals(false, instance.isValid("(]"))
    }

}