package com.sherepenko.leetcode.solutions

class MinStack {
    private data class Node(
        val value: Int,
        var minValue: Int? = null,
        var next: Node? = null
    )

    private var head: Node? = null

    fun push(value: Int) {
        val current = head
        head = Node(value)
        head?.minValue =
            if (current != null && current.minValue!! < value) {
                current.minValue
            } else {
                value
            }

        head?.next = current
    }

    fun pop() {
        head = head?.next
    }

    fun top(): Int? =
        head?.value

    fun getMin(): Int? =
        head?.minValue
}