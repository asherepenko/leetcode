package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import com.sherepenko.leetcode.data.Traversal
import com.sherepenko.leetcode.data.TreeNode
import com.sherepenko.leetcode.data.joinToString

class BinaryTreePreorderTraversal(
    private val values: IntArray
) : Solution {

    companion object {
        fun bstFromPreorder(values: IntArray): TreeNode? {
            if (values.isEmpty()) {
                return null
            }

            val root = TreeNode(values[0])
            val leftSubTree = mutableListOf<Int>()
            val rightSubTree = mutableListOf<Int>()

            for (i in 1 until values.size) {
                if (values[i] < root.value) {
                    leftSubTree.add(values[i])
                } else {
                    rightSubTree.add(values[i])
                }
            }

            root.left = bstFromPreorder(leftSubTree.toIntArray())
            root.right = bstFromPreorder(rightSubTree.toIntArray())

            return root
        }
    }

    override fun resolve() {
        val result = bstFromPreorder(values)

        println(
            "Construct Binary Search Tree from Preorder Traversal: \n" +
                "    Input: ${values.joinToString(prefix = "[", postfix = "]")}; \n" +
                "    Result: ${result?.joinToString(prefix = "[", postfix = "]", traversal = Traversal.LEVEL_ORDER)} \n"
        )
    }
}
