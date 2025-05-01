package hard

import org.junit.jupiter.api.Test
import kotlin.math.ceil
import kotlin.test.assertEquals

//https://leetcode.com/problems/text-justification/description/
class TextJustification {

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()
        var startWordIndex = 0
        while (startWordIndex <= words.lastIndex) {
            val setForString = mutableListOf<String>()
            var potentialStringLengthWithSpaces = 0
            var potentialStringLengthWithoutSpaces = 0
            for (i in startWordIndex..words.lastIndex) {
                val currentWord = words[i]
                val currentWordLength = currentWord.length
                if (currentWordLength + potentialStringLengthWithSpaces <= maxWidth) {
                    setForString.add(currentWord)
                    startWordIndex = i + 1
                    potentialStringLengthWithSpaces += currentWordLength
                    potentialStringLengthWithoutSpaces += currentWordLength
                    if (currentWordLength < maxWidth) {
                        potentialStringLengthWithSpaces += 1
                    }
                } else {
                    break
                }
            }
            if (startWordIndex > words.lastIndex) {
                val lastString = buildString {
                    val withoutTrailingSpaces = setForString.joinToString(" ")
                    append(withoutTrailingSpaces)
                    repeat(maxWidth - withoutTrailingSpaces.length) {
                        append(" ")
                    }
                }
                result.add(lastString)
            } else {
                var spacesToDistribute = maxWidth - potentialStringLengthWithoutSpaces
                var numberOfSpacesBetweenWordsLeft = if (setForString.size == 1) 1 else setForString.size - 1
                val notLastString = buildString {
                    setForString.forEach {
                        append(it)
                        if (numberOfSpacesBetweenWordsLeft > 0) {
                            repeat(ceil(spacesToDistribute.toDouble() / numberOfSpacesBetweenWordsLeft).toInt()) {
                                append(" ")
                                spacesToDistribute--
                            }
                            numberOfSpacesBetweenWordsLeft--
                        }
                    }
                }
                result.add(notLastString)
            }
        }
        return result
    }

}

class TextJustificationTest {

    private val instance = TextJustification()

    @Test
    fun test1() {
        val input = arrayOf("This", "is", "an", "example", "of", "text", "justification.")
        val expectedOutput = listOf(
            "This    is    an",
            "example  of text",
            "justification.  "
        )
        assertEquals(expectedOutput, instance.fullJustify(input, 16))
    }

    @Test
    fun test2() {
        val input = arrayOf("What", "must", "be", "acknowledgment", "shall", "be")
        val expectedOutput = listOf(
            "What   must   be",
            "acknowledgment  ",
            "shall be        "
        )
        assertEquals(expectedOutput, instance.fullJustify(input, 16))
    }

    @Test
    fun test3() {
        val input = arrayOf(
            "Science",
            "is",
            "what",
            "we",
            "understand",
            "well",
            "enough",
            "to",
            "explain",
            "to",
            "a",
            "computer.",
            "Art",
            "is",
            "everything",
            "else",
            "we",
            "do"
        )
        val expectedOutput = listOf(
            "Science  is  what we",
            "understand      well",
            "enough to explain to",
            "a  computer.  Art is",
            "everything  else  we",
            "do                  "
        )
        assertEquals(expectedOutput, instance.fullJustify(input, 20))
    }

    @Test
    fun test4() {
        val input = arrayOf("enough", "to", "explain", "to")
        val expectedOutput = listOf(
            "enough to explain to"
        )
        assertEquals(expectedOutput, instance.fullJustify(input, 20))
    }

}