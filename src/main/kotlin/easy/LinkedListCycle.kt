package easy

import ListNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/linked-list-cycle/
class LinkedListCycle {

    fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) return false
        var fast = head
        var slow = head
        while (fast?.next != null && fast.next?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
            if (slow == fast) return true
        }
        return false
    }

}

class LinkedListCycleTest {

    private val instance = LinkedListCycle()

    @Test
    fun test1() {
        val input = ListNode(3)
        val second = ListNode(2)
        val third = ListNode(0)
        val fourth = ListNode(-4)
        input.next = second
        second.next = third
        third.next = fourth
        fourth.next = second
        assertEquals(true, instance.hasCycle(input))
    }

    @Test
    fun test2() {
        val input = ListNode(1)
        val second = ListNode(2)
        input.next = second
        second.next = input
        assertEquals(true, instance.hasCycle(input))
    }

    @Test
    fun test3() {
        val input = ListNode(1)
        assertEquals(false, instance.hasCycle(input))
    }

}