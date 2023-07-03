package easy

import TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//https://leetcode.com/problems/balanced-binary-tree
class BalancedBinaryTree {

    private var maxDiff = 0

    fun isBalanced(root: TreeNode?): Boolean {
        return kotlin.math.abs(getHeight(root?.left) - getHeight(root?.right)) <= 1 && maxDiff <= 1
    }

    private fun getHeight(node: TreeNode?): Int {
        if (node == null) return -1
        val left = getHeight(node.left)
        val right = getHeight(node.right)
        maxDiff = kotlin.math.max(maxDiff, kotlin.math.abs(left - right))
        return 1 + kotlin.math.max(left, right)
    }

}

class BalancedBinaryTreeTest {

    private val instance = BalancedBinaryTree()

    @Test
    fun test1() {
        val root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
        assertEquals(true, instance.isBalanced(root))
    }

    @Test
    fun test2() {
        val root = TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4), TreeNode(4)), TreeNode(3)), TreeNode(2))
        assertEquals(false, instance.isBalanced(root))
    }

}