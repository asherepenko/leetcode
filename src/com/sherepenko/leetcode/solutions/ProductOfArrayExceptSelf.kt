package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable

class ProductOfArrayExceptSelf(
    private val numbers: IntArray
) : Executable {

    companion object {
        fun productExceptSelf(numbers: IntArray): IntArray {
            val result = IntArray(numbers.size)

            result[0] = 1
            for (i in 1 until numbers.size) {
                result[i] = result[i - 1] * numbers[i - 1]
            }

            var right = 1
            for (i in numbers.lastIndex downTo 0) {
                result[i] = result[i] * right
                right *= numbers[i]
            }

            return result
        }
    }

    override fun execute() {
        val result = productExceptSelf(numbers)
        println(
            "Product of Array Except Self: \n" +
            "    Input: ${numbers.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: ${result.joinToString(prefix = "[", postfix = "]")} \n"
        )
    }
}
