package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable
import kotlin.math.max

class MaxSubArray(
    private val numbers: IntArray
) : Executable {

    companion object {
        fun maxSubArray(numbers: IntArray): Int {
            var localMax = numbers.first()
            var globalMax = numbers.first()

            for (i in 1 until numbers.size) {
                localMax = max(numbers[i], localMax + numbers[i])
                globalMax = max(globalMax, localMax)
            }

            return globalMax
        }
    }

    override fun execute() {
        val result = maxSubArray(numbers)
        println(
            "Maximum Sub Array: \n" +
            "    Input: ${numbers.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: $result \n"
        )
    }
}
