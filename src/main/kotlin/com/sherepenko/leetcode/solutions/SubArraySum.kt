package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class SubArraySum(
    private val numbers: IntArray,
    private val value: Int
) : Solution {

    companion object {
        fun subArraySum(numbers: IntArray, value: Int): Int {
            val map = mutableMapOf(
                0 to 1
            )

            var count = 0
            var sum = 0

            for (number in numbers) {
                sum += number
                count += map.getOrDefault(sum - value, 0)
                map[sum] = map.getOrDefault(sum, 0) + 1
            }

            return count
        }
    }

    override fun resolve() {
        val result = subArraySum(numbers, value)

        println(
            "Subarray Sum Equals K: \n" +
                "    Input: ${numbers.joinToString(prefix = "[", postfix = "]")}; K = $value \n" +
                "    Result: $result\n"
        )
    }
}
