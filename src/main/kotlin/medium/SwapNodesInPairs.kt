package medium

import ListNode
import assertNodesEquals
import org.junit.jupiter.api.Test

//https://leetcode.com/problems/swap-nodes-in-pairs/description/
class SwapNodesInPairs {

    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }
        val dummy = ListNode(0)
        dummy.next = head
        var current = dummy
        while (current.next != null && current.next!!.next != null) {
            val first = current.next
            val second = current.next!!.next
            current.next = second
            first!!.next = second!!.next
            second.next = first
            current = current.next!!.next!!
        }
        return dummy.next
    }

}

class SwapNodesInPairsTest {

    private val swapNodesInPairs = SwapNodesInPairs()

    @Test
    fun test1() {
        val inputNode = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(
                        4,
                    )
                )
            )
        )
        val expectedNode = ListNode(
            2,
            ListNode(
                1,
                ListNode(
                    4,
                    ListNode(
                        3
                    )
                )
            )
        )
        swapNodesInPairs.swapPairs(inputNode).assertNodesEquals(expectedNode)
    }

    @Test
    fun test2() {
        swapNodesInPairs.swapPairs(null).assertNodesEquals(null)
    }

    @Test
    fun test3() {
        val inputNode = ListNode(
            1,
        )
        val expectedNode = ListNode(
            1,
        )
        swapNodesInPairs.swapPairs(inputNode).assertNodesEquals(expectedNode)
    }

    @Test
    fun test4() {
        val inputNode = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                )
            )
        )
        val expectedNode = ListNode(
            2,
            ListNode(
                1,
                ListNode(
                    3,
                )
            )
        )
        swapNodesInPairs.swapPairs(inputNode).assertNodesEquals(expectedNode)
    }

}