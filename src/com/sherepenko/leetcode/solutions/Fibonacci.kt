package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable

class Fibonacci(
    private val number: Int
) : Executable {

    companion object {
        fun fibonacci(number: Int): IntArray {
            return when (number) {
                1 -> {
                    intArrayOf(0)
                }
                2 -> {
                    intArrayOf(0, 1)
                }
                else -> {
                    val numbers = IntArray(number)
                    numbers[0] = 0
                    numbers[1] = 1

                    for (i in 2 until numbers.size) {
                        numbers[i] = numbers[i - 1] + numbers[i - 2]
                    }

                    numbers
                }
            }
        }
    }

    override fun execute() {
        val result = fibonacci(number)
        println(
            "Fibonacci sequence: \n" +
            "    Input: $number; \n" +
            "    Result: ${result.joinToString(prefix = "[", postfix = "]")} \n"
        )
    }
}