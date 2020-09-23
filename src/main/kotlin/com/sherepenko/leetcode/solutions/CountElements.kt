package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class CountElements(
    private val numbers: IntArray
) : Solution {

    companion object {
        fun countElements(numbers: IntArray): Int {
            var count = 0
            val set = numbers.toSet()

            numbers.forEach {
                if (set.contains(it + 1)) {
                    count++
                }
            }

            return count
        }
    }

    override fun resolve() {
        val result = countElements(numbers)
        println(
            "Counting Elements: \n" +
                "    Input: ${numbers.joinToString(prefix = "[", postfix = "]")}; \n" +
                "    Result: $result \n"
        )
    }
}
