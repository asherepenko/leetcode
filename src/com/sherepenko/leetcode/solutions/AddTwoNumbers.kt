package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable
import com.sherepenko.leetcode.data.ListNode
import com.sherepenko.leetcode.data.joinToString

class AddTwoNumbers(
    private val head1: ListNode?,
    private val head2: ListNode?
) : Executable {

    companion object {
        fun addTwoNumbers(head1: ListNode?, head2: ListNode?): ListNode? {
            val dummyHead = ListNode(0)

            var node1 = head1
            var node2 = head2
            var current = dummyHead

            var remainder = 0

            while (node1 != null || node2 != null) {
                val value1 = node1?.value ?: 0
                val value2 = node2?.value ?: 0

                val sum = value1 + value2 + remainder
                remainder = sum / 10

                current.next = ListNode(sum % 10)
                current = current.next!!

                if (node1 != null) {
                    node1 = node1.next
                }

                if (node2 != null) {
                    node2 = node2.next
                }
            }

            if (remainder > 0) {
                current.next = ListNode(remainder)
            }

            return dummyHead.next
        }
    }

    override fun execute() {
        val result = addTwoNumbers(head1, head2)
        println(
            "Add Two Numbers: \n" +
            "    Input: ${head1?.joinToString(prefix = "[", postfix = "]")}, ${head2?.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: ${result?.joinToString(prefix = "[", postfix = "]")} \n"
        )
    }
}
