package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable
import java.util.*

class BackspaceCompare(
    private val strFirst: String,
    private val strLast: String
) : Executable {

    companion object {
        fun backspaceCompare(strFirst: String, strLast: String): Boolean =
            strFirst.backspace() == strLast.backspace()

        private fun String.backspace(): String {
            val stack = Stack<Char>()
            this.toCharArray()
                .forEach {
                    if (it != '#') {
                        stack.push(it)
                    } else if (!stack.empty()) {
                        stack.pop()
                    }
                }
            return stack.joinToString("")
        }
    }

    override fun execute() {
        val result = backspaceCompare(strFirst, strLast)
        println(
            "Backspace String Compare: \n" +
            "    Input: $strFirst, $strLast; \n" +
            "    Result: $result \n"
        )
    }
}