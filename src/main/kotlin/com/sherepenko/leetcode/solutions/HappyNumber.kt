package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class HappyNumber(
    private val number: Int
) : Solution {
    companion object {
        fun isHappy(number: Int): Boolean {
            var sum = number

            while (sum >= 10) {
                sum = sum.squareSum()
            }

            return sum == 1 || sum == 7
        }

        private fun Int.squareSum(): Int {
            var number = this
            var sum = 0

            while (number > 0) {
                sum += (number % 10) * (number % 10)
                number /= 10
            }

            return sum
        }
    }

    override fun resolve() {
        val result = isHappy(number)
        println(
            "Happy Number: \n" +
                "    Input: $number; \n" +
                "    Result: $result \n"
        )
    }
}
