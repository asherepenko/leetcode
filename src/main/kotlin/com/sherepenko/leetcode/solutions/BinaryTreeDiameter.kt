package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import com.sherepenko.leetcode.data.TreeNode
import com.sherepenko.leetcode.data.height
import com.sherepenko.leetcode.data.joinToString
import com.sherepenko.leetcode.data.size
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.max

class BinaryTreeDiameter(
    private val root: TreeNode?
) : Solution {

    companion object {
        fun diameterOfBinaryTree(root: TreeNode?): Int {
            val diameter = AtomicInteger(0)
            root.diameter(diameter)
            return diameter.get()
        }

        private fun TreeNode?.diameter(diameter: AtomicInteger): Int {
            if (this == null) {
                return 0
            }

            val heightLeft = left.diameter(diameter)
            val heightRight = right.diameter(diameter)

            diameter.set(
                max(diameter.get(), heightLeft + heightRight)
            )

            return max(heightLeft, heightRight) + 1
        }
    }

    override fun resolve() {
        val result = diameterOfBinaryTree(root)
        println(
            "Diameter of Binary Tree: \n" +
                "    Input: ${root?.joinToString(prefix = "[", postfix = "]")}, ${root.size()}; \n" +
                "    Height: ${root.height() - 1}; \n" +
                "    Diameter: $result \n"
        )
    }
}
