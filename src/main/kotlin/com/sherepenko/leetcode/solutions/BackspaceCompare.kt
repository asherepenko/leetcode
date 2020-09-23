package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import java.util.Stack

class BackspaceCompare(
    private val strFirst: String,
    private val strLast: String
) : Solution {

    companion object {
        fun backspaceCompare(strFirst: String, strLast: String): Boolean =
            strFirst.backspace() == strLast.backspace()

        private fun String.backspace(): String {
            val stack = Stack<Char>()
            forEach {
                if (it != '#') {
                    stack.push(it)
                } else if (!stack.empty()) {
                    stack.pop()
                }
            }
            return stack.joinToString("")
        }
    }

    override fun resolve() {
        val result = backspaceCompare(strFirst, strLast)
        println(
            "Backspace String Compare: \n" +
                "    Input: $strFirst, $strLast; \n" +
                "    Result: $result \n"
        )
    }
}
