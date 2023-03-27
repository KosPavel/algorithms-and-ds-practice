class ListNode(val `val`: Int, var next: ListNode? = null) {

    override fun toString(): String {
        return `val`.toString() + " " + if (next != null) next?.toString() else ""
    }

    companion object {
        fun generate(nums: List<Int>): ListNode {
            if (nums.isEmpty()) throw Exception("List must not be empty!")
            val result = ListNode(nums.first())
            for (i in 1 until nums.size) {
                val addition = ListNode(nums[i])
                var ref = result
                while (ref.next != null) {
                    ref = ref.next!!
                }
                ref.next = addition
            }
            return result
        }
    }
}

fun ListNode?.assertNodesEquals(expected: ListNode?) {
    var thisNext: ListNode? = this
    var expectedNext: ListNode? = expected
    while (thisNext != null) {
        if (thisNext.`val` != expectedNext?.`val`) throw AssertionError("expected $expected, actual $this")
        thisNext = thisNext.next
        expectedNext = expectedNext.next
    }
    if (thisNext?.`val` != expectedNext?.`val` || thisNext?.next != null || expectedNext?.next != null) throw AssertionError(
        "expected $expected, actual $this"
    )
}