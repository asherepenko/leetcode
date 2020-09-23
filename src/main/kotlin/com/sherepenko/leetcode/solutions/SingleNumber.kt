package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class SingleNumber(
    private val numbers: IntArray
) : Solution {

    companion object {
        fun singleNumber(numbers: IntArray): Int {
            var result = numbers.first()

            for (i in 1 until numbers.size) {
                result = result xor numbers[i]
            }

            return result
        }
    }

    override fun resolve() {
        val result = singleNumber(numbers)
        println(
            "Single Number: \n" +
                "    Input: ${numbers.joinToString(prefix = "[", postfix = "]")}; \n" +
                "    Result: $result \n"
        )
    }
}
