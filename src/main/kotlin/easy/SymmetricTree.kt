package easy

import TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/symmetric-tree/
class SymmetricTree {

    fun isSymmetric(root: TreeNode?): Boolean {
        return isNodesSymmetric(root?.left, root?.right)
    }

    private fun isNodesSymmetric(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        return p?.`val` == q?.`val` && isNodesSymmetric(p?.left, q?.right) && isNodesSymmetric(p?.right, q?.left)
    }

}

class SymmetricTreeTest {

    private val instance = SymmetricTree()

    @Test
    fun test1() {
        val left = TreeNode(2, TreeNode(3), TreeNode(4))
        val right = TreeNode(2, TreeNode(4), TreeNode(3))
        val root = TreeNode(1, left, right)
        assertEquals(true, instance.isSymmetric(root))
    }

    @Test
    fun test2() {
        val left = TreeNode(2, TreeNode(3))
        val right = TreeNode(2, TreeNode(3))
        val root = TreeNode(1, left, right)
        assertEquals(false, instance.isSymmetric(root))
    }

}