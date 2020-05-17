package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable
import kotlin.math.max
import kotlin.math.min

class MaximalSquare(
    private val matrix: Array<CharArray>
) : Executable {

    companion object {
        fun maximalSquare(matrix: Array<CharArray>): Int {
            val m = matrix.size + 1
            val n = if (matrix.isNotEmpty()) matrix[0].size + 1 else 1

            val dp = IntArray(n)

            var prev = 0
            var maxSquareLength = 0

            for (i in 1 until m) {
                for (j in 1 until n) {
                    val tmp = dp[j]
                    if (matrix[i - 1][j - 1] == '1') {
                        dp[j] = min(min(dp[j - 1], prev), dp[j]) + 1
                        maxSquareLength = max(maxSquareLength, dp[j])
                    } else {
                        dp[j] = 0
                    }
                    prev = tmp
                }
            }

            return maxSquareLength * maxSquareLength
        }
    }

    override fun execute() {
        println("Maximal Square:")
        println("    Input:")
        matrix.forEach {
            println("    ${it.joinToString(separator = " ")}")
        }
        println("    Result: ${maximalSquare(matrix)} \n")
    }
}