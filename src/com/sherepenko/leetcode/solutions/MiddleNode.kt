package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import com.sherepenko.leetcode.data.ListNode
import com.sherepenko.leetcode.data.joinToString

class MiddleNode(
    private val head: ListNode?
) : Solution {

    companion object {
        fun middleNode(head: ListNode?): ListNode? {
            var fastPtr = head
            var slowPtr = head

            while (fastPtr?.next != null) {
                fastPtr = fastPtr.next!!.next
                slowPtr = slowPtr?.next
            }

            return slowPtr
        }
    }

    override fun resolve() {
        val result = middleNode(head)
        println(
            "Middle Node: \n" +
            "    Input: ${head?.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: $result \n"
        )
    }
}
