package easy

import ListNode
import assertNodesEquals
import org.junit.jupiter.api.Test

//https://leetcode.com/problems/middle-of-the-linked-list/
class MiddleLinkedList {

    fun middleNode(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var i = head
        var j = head
        while (j?.next != null) {
            i = i?.next
            j = j.next?.next
        }
        return i
    }

}

class MiddleLinkedListTest {

    private val middleLinkedList = MiddleLinkedList()

    @Test
    fun searchInsertTest1() {
        val inputNode = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(
                        4,
                        ListNode(
                            5
                        )
                    )
                )
            )
        )
        val expectedNode = ListNode(
            3,
            ListNode(
                4,
                ListNode(
                    5
                )
            )
        )
        middleLinkedList.middleNode(inputNode).assertNodesEquals(expectedNode)
    }

    @Test
    fun searchInsertTest2() {
        val inputNode = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(
                        4,
                        ListNode(
                            5,
                            ListNode(
                                6
                            )
                        )
                    )
                )
            )
        )
        val expectedNode = ListNode(
            4,
            ListNode(
                5,
                ListNode(
                    6
                )
            )
        )
        middleLinkedList.middleNode(inputNode).assertNodesEquals(expectedNode)
    }

}