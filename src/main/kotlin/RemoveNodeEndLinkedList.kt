import org.junit.jupiter.api.Test

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class RemoveNodeEndLinkedList {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var slow = head
        var fast = head
        for (i in 0 until n) {
            fast = fast!!.next
            if (fast == null) return head!!.next
        }
        while (fast!!.next != null) {
            slow = slow!!.next
            fast = fast.next
        }
        slow!!.next = slow.next!!.next
        return head
    }

}

class RemoveNodeEndLinkedListTest {

    private val removeNodeEndLinkedList = RemoveNodeEndLinkedList()

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
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(
                        5
                    )
                )
            )
        )
        removeNodeEndLinkedList.removeNthFromEnd(inputNode, 2).assertNodesEquals(expectedNode)
    }

    @Test
    fun searchInsertTest2() {
        val inputNode = ListNode(
            1,
            ListNode(
                2
            )
        )
        val expectedNode = ListNode(1)
        removeNodeEndLinkedList.removeNthFromEnd(inputNode, 1).assertNodesEquals(expectedNode)
    }

    @Test
    fun searchInsertTest3() {
        val inputNode = ListNode(
            1
        )
        val expectedNode = null
        removeNodeEndLinkedList.removeNthFromEnd(inputNode, 1).assertNodesEquals(expectedNode)
    }

    @Test
    fun searchInsertTest4() {
        val inputNode = ListNode(
            1,
            ListNode(
                2
            )
        )
        val expectedNode = ListNode(2)
        removeNodeEndLinkedList.removeNthFromEnd(inputNode, 2).assertNodesEquals(expectedNode)
    }

}