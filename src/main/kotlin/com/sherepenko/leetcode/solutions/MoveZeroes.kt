package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class MoveZeroes(
    private val numbers: IntArray
) : Solution {

    companion object {
        fun moveZeroes(numbers: IntArray): IntArray {
            var count = 0

            for (i in numbers.indices) {
                if (numbers[i] != 0) {
                    val tmp = numbers[count]
                    numbers[count] = numbers[i]
                    numbers[i] = tmp
                    count++
                }
            }

            return numbers
        }
    }

    override fun resolve() {
        println(
            "Move Zeroes: \n" +
            "    Input: ${numbers.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: ${moveZeroes(numbers).joinToString(prefix = "[", postfix = "]")}} \n"
        )
    }
}
