package easy

import TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/same-tree/
class SameTree {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        return p?.`val` == q?.`val` && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }

}

class SameTreeTest {

    private val instance = SameTree()

    @Test
    fun test1() {
        val tree1 = TreeNode(1, TreeNode(2), TreeNode(3))
        val tree2 = TreeNode(1, TreeNode(2), TreeNode(3))
        assertEquals(true, instance.isSameTree(tree1, tree2))
    }

    @Test
    fun test2() {
        val tree1 = TreeNode(1, TreeNode(2))
        val tree2 = TreeNode(1, null, TreeNode(2))
        assertEquals(false, instance.isSameTree(tree1, tree2))
    }

    @Test
    fun test3() {
        val tree1 = TreeNode(1, TreeNode(2), TreeNode(1))
        val tree2 = TreeNode(1, TreeNode(1), TreeNode(2))
        assertEquals(false, instance.isSameTree(tree1, tree2))
    }

}