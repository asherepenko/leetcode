package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable

class MinPathSum(
    private val grid: Array<IntArray>
) : Executable {

    companion object {
        fun minPathSum(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size

            val dp = Array(m) {
                IntArray(n)
            }

            dp[0][0] = grid[0][0]

            for (i in 1 until m) {
                dp[i][0] = dp[i - 1][0] + grid[i][0]
            }

            for (j in 1 until n) {
                dp[0][j] = dp[0][j - 1] + grid[0][j]
            }

            println("    Initial Matrix:")
            dp.forEach {
                println("    ${it.joinToString(separator = " ")}")
            }

            for (i in 1 until m) {
                for (j in 1 until n) {
                    dp[i][j] = if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j - 1] + grid[i][j]
                    } else {
                        dp[i - 1][j] + grid[i][j]
                    }
                }
            }

            println("    Result Matrix:")
            dp.forEach {
                println("    ${it.joinToString(separator = " ")}")
            }

            return dp[m - 1][n - 1]
        }
    }

    override fun execute() {
        val result = minPathSum(grid)
        println("    Input:")
        grid.forEach {
            println("    ${it.joinToString(separator = " ")}")
        }
        println("    Result: $result \n")
    }
}
