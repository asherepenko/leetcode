package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import com.sherepenko.leetcode.data.ListNode
import com.sherepenko.leetcode.data.joinToString

class ReverseLinkedList(
    private val head: ListNode?
) : Solution {

    companion object {
        fun reverseListIterative(head: ListNode?): ListNode? {
            var current = head
            var previous: ListNode? = null

            while (current != null) {
                val next = current.next
                current.next = previous
                previous = current
                current = next
            }

            return previous
        }

        fun reverseListRecursive(head: ListNode?): ListNode? {
            if (head?.next == null) {
                return head
            }

            val node = reverseListRecursive(head.next)
            head.next?.next = head
            head.next = null

            return node
        }
    }

    override fun resolve() {
        println(
            "Reverse Linked List: \n" +
                "    Input: ${head?.joinToString(prefix = "[", postfix = "]")}; \n" +
                "    Result: ${reverseListIterative(head)?.joinToString(prefix = "[", postfix = "]")} \n"
        )
    }
}
