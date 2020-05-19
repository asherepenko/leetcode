package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import com.sherepenko.leetcode.data.TreeNode
import com.sherepenko.leetcode.data.joinToString
import com.sherepenko.leetcode.data.prettifyPrint
import java.util.concurrent.atomic.AtomicInteger
import kotlin.math.max

class BinaryTreeMaxPathSum(
    private val root: TreeNode?
) : Solution {

    companion object {
        fun maxPathSum(root: TreeNode?): Int {
            val sum = AtomicInteger(Int.MIN_VALUE)
            root.pathSum(sum)
            return sum.get()
        }

        private fun TreeNode?.pathSum(sum: AtomicInteger): Int {
            if (this == null) {
                return 0
            }

            val sumLeft = left.pathSum(sum)
            val sumRight = right.pathSum(sum)

            val sumCurrent = max(value, value + max(sumLeft, sumRight))

            sum.set(
                max(sum.get(), max(sumCurrent, sumLeft + value + sumRight))
            )

            return sumCurrent
        }
    }

    override fun resolve() {
        val result = maxPathSum(root)
        println(
            "Diameter of Binary Tree: \n" +
            "    Input: ${root?.joinToString(prefix = "[", postfix = "]")} \n" +
            "    Result: $result \n"
        )
        root?.prettifyPrint(4)
    }
}
