package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable
import com.sherepenko.leetcode.data.ListNode
import com.sherepenko.leetcode.data.joinToString

class OddEvenList(
    private val head: ListNode?
) : Executable {

    companion object {
        fun oddEvenList(head: ListNode?): Array<ListNode?> {
            var current = head
            var oddHead: ListNode? = null
            var evenHead: ListNode? = null

            while (current != null) {
                val value = current.value

                if (value % 2 == 0) {
                    evenHead = evenHead.addFirst(value)
                } else {
                    oddHead = oddHead.addFirst(value)
                }

                current = current.next
            }

            return arrayOf(oddHead, evenHead)
        }

        private fun ListNode?.addFirst(value: Int): ListNode {
            val node = ListNode(value)
            node.next = this
            return node
        }
    }

    override fun execute() {
        val result = oddEvenList(head)

        println(
            "Odd and Even Lists: \n" +
            "    Input: ${head?.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: ${result[0]?.joinToString(prefix = "[", postfix = "]")}, ${result[1]?.joinToString(prefix = "[", postfix = "]")}\n"
        )
    }
}
