package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable

class MinPathSum(
    private val grid: Array<IntArray>
) : Executable {

    companion object {
        fun minPathSum(grid: Array<IntArray>): Int {
            val m = grid.size
            val n = grid[0].size

            val matrix = Array(m) {
                IntArray(n)
            }

            matrix[0][0] = grid[0][0]

            for (i in 1 until m) {
                matrix[i][0] = matrix[i - 1][0] + grid[i][0]
            }

            for (j in 1 until n) {
                matrix[0][j] = matrix[0][j - 1] + grid[0][j]
            }

            println("    Initial Matrix:")
            matrix.forEach {
                println("    ${it.joinToString(separator = " ")}")
            }

            for (i in 1 until m) {
                for (j in 1 until n) {
                    matrix[i][j] = if (matrix[i - 1][j] > matrix[i][j - 1]) {
                        matrix[i][j - 1] + grid[i][j]
                    } else {
                        matrix[i - 1][j] + grid[i][j]
                    }
                }
            }

            println("    Result Matrix:")
            matrix.forEach {
                println("    ${it.joinToString(separator = " ")}")
            }

            return matrix[m - 1][n - 1]
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
