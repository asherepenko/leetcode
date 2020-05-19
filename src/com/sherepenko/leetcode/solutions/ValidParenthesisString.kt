package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import kotlin.math.max

class ValidParenthesisString(
    private val str: String
) : Solution {

    companion object {
        fun checkValidString(str: String): Boolean {
            var lo = 0
            var hi = 0
            for (char in str) {
                lo += if (char == '(') 1 else -1
                hi += if (char != ')') 1 else -1

                if (hi < 0) {
                    break
                }

                lo = max(lo, 0)
            }

            return lo == 0
        }
    }

    override fun resolve() {
        val result = checkValidString(str)
        println(
            "Valid Parenthesis String: \n" +
            "    Input: $str; \n" +
            "    Result: $result \n"
        )
    }
}
