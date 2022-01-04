package medium

import ListNode
import assertNodesEquals
import org.junit.jupiter.api.Test

//https://leetcode.com/problems/add-two-numbers/
class AddTwoNumbers {

    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode {
        var l1Temp: ListNode? = l1
        var l2Temp: ListNode? = l2
        var shouldIncrement = false
        val reversedNumber = mutableListOf<Int>()
        while (!(l1Temp == null && l2Temp == null)) {
            var value: Int = when {
                l1Temp != null && l2Temp != null -> {
                    l1Temp.`val` + l2Temp.`val`
                }
                l1Temp == null && l2Temp != null -> {
                    l2Temp.`val`
                }
                else -> {
                    l1Temp!!.`val`
                }
            }
            if (shouldIncrement) {
                value += 1
                shouldIncrement = false
            }
            if (value >= 10) {
                shouldIncrement = true
                value -= 10
            }
            reversedNumber.add(value)
            l1Temp?.let {
                l1Temp = it.next
            }
            l2Temp?.let {
                l2Temp = it.next
            }
        }
        if (shouldIncrement) {
            reversedNumber.add(1)
        }
        return ListNode.generate(reversedNumber)
    }

}

class AddTwoNumbersTest {

    private val addTwoNumbers = AddTwoNumbers()

    @Test
    fun addTwoNumbersTest1() {
        val inputNode1 = ListNode.generate(listOf(2, 4, 3))
        val inputNode2 = ListNode.generate(listOf(5, 6, 4))
        val expectedNode = ListNode.generate(listOf(7, 0, 8))
        addTwoNumbers.addTwoNumbers(inputNode1, inputNode2).assertNodesEquals(expectedNode)
    }

    @Test
    fun addTwoNumbersTest2() {
        val inputNode1 = ListNode(0)
        val inputNode2 = ListNode(0)
        val expectedNode = ListNode(0)
        addTwoNumbers.addTwoNumbers(inputNode1, inputNode2).assertNodesEquals(expectedNode)
    }

    @Test
    fun addTwoNumbersTest3() {
        val inputNode1 = ListNode.generate(listOf(9, 9, 9, 9, 9, 9, 9))
        val inputNode2 = ListNode.generate(listOf(9, 9, 9, 9))
        val expectedNode = ListNode.generate(listOf(8, 9, 9, 9, 0, 0, 0, 1))
        addTwoNumbers.addTwoNumbers(inputNode1, inputNode2).assertNodesEquals(expectedNode)
    }

}
