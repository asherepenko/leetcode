package com.sherepenko.leetcode.data

import kotlin.math.max

const val TREE_INDENTATION = 10

enum class Traversal {
    PRE_ORDER,
    IN_ORDER,
    POST_ORDER,
    LEVEL_ORDER
}

data class TreeNode(
    val value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
) {
    override fun toString(): String =
        value.toString()
}

fun TreeNode?.height(): Int {
    if (this == null) {
        return 0
    }

    return max(left.height(), right.height()) + 1
}

fun TreeNode?.size(): Int {
    if (this == null) {
        return 0
    }

    return left.size() + right.size() + 1
}

fun TreeNode?.prettifyPrint(space: Int = 0) {
    if (this == null) {
        return
    }

    val indentation = space + TREE_INDENTATION

    right?.prettifyPrint(indentation)
    println()

    for (i in TREE_INDENTATION until indentation) {
        print(" ")
    }
    println(this)

    left?.prettifyPrint(indentation)
}

fun TreeNode.joinToString(separator: String = ", ", prefix: String = "", postfix: String = "", traversal: Traversal = Traversal.PRE_ORDER): String {
    val builder = StringBuilder()

    builder.append(prefix)

    when (traversal) {
        Traversal.PRE_ORDER -> {
            preOrderTraversal(this, builder, separator)
        }
        Traversal.IN_ORDER -> {
            inOrderTraversal(this, builder, separator)
        }
        Traversal.POST_ORDER -> {
            postOrderTraversal(this, builder, separator)
        }
        Traversal.LEVEL_ORDER -> {
            for (i in 1..this.height()) {
                levelOrderTraversal(this, i, builder, separator)
            }
        }
    }

    builder.setLength(builder.length - separator.length)

    builder.append(postfix)

    return builder.toString()
}

private fun preOrderTraversal(node: TreeNode?, builder: StringBuilder, separator: String) {
    if (node == null) {
        return
    }

    builder.append(node.value).append(separator)

    preOrderTraversal(node.left, builder, separator)
    preOrderTraversal(node.right, builder, separator)
}

private fun inOrderTraversal(node: TreeNode?, builder: StringBuilder, separator: String) {
    if (node == null) {
        return
    }

    inOrderTraversal(node.left, builder, separator)
    builder.append(node.value).append(separator)
    inOrderTraversal(node.right, builder, separator)
}

private fun postOrderTraversal(node: TreeNode?, builder: StringBuilder, separator: String) {
    if (node == null) {
        return
    }

    postOrderTraversal(node.left, builder, separator)
    postOrderTraversal(node.right, builder, separator)
    builder.append(node.value).append(separator)
}

private fun levelOrderTraversal(node: TreeNode?, level: Int, builder: StringBuilder, separator: String) {
    if (node == null) {
        return
    }

    if (level == 1) {
        builder.append(node.value).append(separator)
    } else if (level > 1) {
        levelOrderTraversal(node.left, level - 1, builder, separator)
        levelOrderTraversal(node.right, level - 1, builder, separator)
    }
}
