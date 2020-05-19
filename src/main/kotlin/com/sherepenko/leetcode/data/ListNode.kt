package com.sherepenko.leetcode.data

data class ListNode(
    val value: Int,
    var next: ListNode? = null
) {
    override fun toString(): String =
        value.toString()
}

fun ListNode?.size(): Int {
    var size = 0
    var current = this

    while (current != null) {
        size++
        current = current.next
    }

    return size
}

fun ListNode.joinToString(separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val builder = StringBuilder()
    var current: ListNode? = this
    var count = 0

    builder.append(prefix)

    while (current != null) {
        if (++count > 1) {
            builder.append(separator)
        }

        builder.append(current.toString())
        current = current.next
    }

    builder.append(postfix)
    return builder.toString()
}
