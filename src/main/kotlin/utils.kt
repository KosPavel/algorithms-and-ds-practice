class ListNode(val `val`: Int, var next: ListNode? = null)

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

fun String.isUniqueSymbols(): Boolean {
    return this.length == this.toSet().size
}