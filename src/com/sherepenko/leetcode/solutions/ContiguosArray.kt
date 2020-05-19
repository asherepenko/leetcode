package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import kotlin.math.max

class ContiguosArray(
    private val numbers: IntArray
) : Solution {

    companion object {
        fun findMaxLength(numbers: IntArray): Int {
            var count = 0
            var maxLength = 0

            val map = mutableMapOf(
                count to -1
            )

            for ((index, value) in numbers.withIndex()) {
                count += if (value == 1) 1 else -1

                if (map.containsKey(count)) {
                    maxLength = max(maxLength, index - map[count]!!)
                } else {
                    map[count] = index
                }
            }

            return maxLength
        }
    }

    override fun resolve() {
        val result = findMaxLength(numbers)
        println(
            "Contiguous Array: \n" +
            "    Input: ${numbers.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: $result \n"
        )
    }
}
