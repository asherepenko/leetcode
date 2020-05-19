package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class TwoSum(
    private val numbers: IntArray,
    private val target: Int
) : Solution {

    companion object {

        fun twoSum(numbers: IntArray, target: Int): IntArray {
            val indices = mutableMapOf<Int, Int>()

            for ((index, value) in numbers.withIndex()) {
                val diff = target - value

                if (indices.containsKey(diff)) {
                    return intArrayOf(indices[diff]!!, index)
                }

                indices[value] = index
            }

            throw IllegalArgumentException("There are no two numbers add up to $target")
        }
    }

    override fun resolve() {
        try {
            val result = twoSum(numbers, target)
            println(
                "Two Sum: \n" +
                "    Input: ${numbers.joinToString(prefix = "[", postfix = "]")}, $target; \n" +
                "    Result: ${result.joinToString(prefix = "[", postfix = "]")} \n"
            )
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
