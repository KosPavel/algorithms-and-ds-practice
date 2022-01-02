package easy

import ListNode
import assertNodesEquals
import org.junit.jupiter.api.Test

//https://leetcode.com/problems/reverse-linked-list/
class ReverseLinkedList {

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        return if (head.next == null) head
        else {
            val newNode = reverseList(head.next)
            head.next!!.next = head
            head.next = null
            newNode
        }
    }

}

class ReverseLinkedListTest {

    private val reverseLinkedList = ReverseLinkedList()

    @Test
    fun searchInsertTest1() {
        val inputNode = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
        val expectedNode = ListNode(5, ListNode(4, ListNode(3, ListNode(2, ListNode(1)))))
        reverseLinkedList.reverseList(inputNode).assertNodesEquals(expectedNode)
    }

    @Test
    fun searchInsertTest2() {
        val inputNode = ListNode(1, ListNode(2, ListNode(3)))
        val expectedNode = ListNode(3, ListNode(2, ListNode(1)))
        reverseLinkedList.reverseList(inputNode).assertNodesEquals(expectedNode)
    }

    @Test
    fun searchInsertTest3() {
        val inputNode = ListNode(1, ListNode(2))
        val expectedNode = ListNode(2, ListNode(1))
        reverseLinkedList.reverseList(inputNode).assertNodesEquals(expectedNode)
    }

    @Test
    fun searchInsertTest4() {
        val inputNode = null
        val expectedNode = null
        reverseLinkedList.reverseList(inputNode).assertNodesEquals(expectedNode)
    }

}