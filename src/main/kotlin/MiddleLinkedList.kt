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

class ListNode(val `val`: Int, val next: ListNode? = null)

fun ListNode?.assertNodesEquals(expected: ListNode?) {
    var thisNext: ListNode? = this
    var expectedNext: ListNode? = expected
    while (thisNext != null) {
        if (thisNext.`val` != expectedNext?.`val`) throw AssertionError()
        thisNext = thisNext.next
        expectedNext = expectedNext.next
    }
    if (thisNext?.`val` != expectedNext?.`val` || thisNext?.next != null || expectedNext?.next != null) throw AssertionError()
}