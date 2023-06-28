package hard

import ListNode
import assertNodesEquals
import org.junit.jupiter.api.Test
import java.util.*

//https://leetcode.com/problems/merge-k-sorted-lists/
class MergeKSortedLists {

        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            val queue = PriorityQueue<ListNode> { a, b -> a.`val`-b.`val` }
            for (list in lists) {
                if (list != null) {
                    queue.add(list)
                }
            }

            var head: ListNode? = null
            var last: ListNode? = null
            while (queue.isNotEmpty()) {
                val top = queue.peek()
                queue.remove()
                if(top?.next != null) {
                    queue.add(top.next)
                }
                if (head == null) {
                    head = top
                    last = top
                } else {
                    last?.next = top
                    last = top
                }
            }
            return head
        }

//    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
//        if (lists.size == 1) return lists[0]
//        val list1 = mutableListOf<ListNode?>()
//        val list2 = mutableListOf<ListNode?>()
//        lists.forEachIndexed { index, listNode ->
//            if (index % 2 == 0) {
//                list1.add(listNode)
//            } else {
//                list2.add(listNode)
//            }
//        }
//        val l = mergeKLists(list1.toTypedArray())
//        val r = mergeKLists(list2.toTypedArray())
//        return mergeTwoLists(l, r)
//    }
//
//    private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
//        val dummy = ListNode(-1)
//        var head = dummy.next
//        var l: ListNode? = list1
//        var r: ListNode? = list2
//        while (l != null || r != null) {
//            if (l != null && r != null) {
//                if (l.`val` < r.`val`) {
//                    head = l
//                    l = l.next
//                } else {
//                    head = r
//                    r = r.next
//                }
//            } else if (l == null && r != null) {
//                head = r
//                r = r.next
//            } else if (l != null && r == null) {
//                head = l
//                l = l.next
//            }
//            head = head?.next
//        }
//        return dummy.next
//    }

}

class MergeKSortedListsTest {

    private val instance = MergeKSortedLists()

    @Test
    fun test1() {
        val list1 = ListNode(1, ListNode(4, ListNode(5, null)))
        val list2 = ListNode(1, ListNode(3, ListNode(4, null)))
        val list3 = ListNode(2, ListNode(6, null))
        val expected =
            ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(4, ListNode(5, ListNode(6))))))))
        instance.mergeKLists(arrayOf(list1, list2, list3))?.assertNodesEquals(expected)
    }
}