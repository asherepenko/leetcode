package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class RangeBitwiseAnd(
    private val first: Int,
    private val last: Int
) : Solution {

    companion object {
        fun rangeBitwiseAnd(first: Int, last: Int): Int {
            var current = last

            while (current > first) {
                current = current and current - 1
            }

            return first and current
        }

        fun rangeBitwiseAndLsb(first: Int, last: Int): Int {
            var current = last

            while (first < current) {
                current -= current and -current
            }

            return current
        }
    }

    override fun resolve() {
        val result = rangeBitwiseAnd(first, last)

        println(
            "Bitwise AND of Numbers Range: \n" +
                "    Input: [$first, $last] \n" +
                "    Result: $result\n"
        )
    }
}
