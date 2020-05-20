package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class NumberOfIslands(
    private val grid: Array<CharArray>
) : Solution {

    companion object {
        fun numIslandsI(grid: Array<CharArray>): Int {
            var count = 0

            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (grid[i][j] == '1') {
                        findIslandDfs(grid, i, j)
                        count++
                    }
                }
            }

            return count
        }

        fun numIslandsII(grid: Array<CharArray>): Int {
            val m = grid.size
            val n = grid[0].size
            val dx = intArrayOf(1, 0)
            val dy = intArrayOf(0, 1)

            val dp = IntArray(m * n)

            var count = 0

            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (grid[i][j] == '1') {
                        dp[i * n + j] = i * n + j
                        count++
                    }
                }
            }

            fun union(p: Int, q: Int) {
                val pRoot = dp.find(p)
                val qRoot = dp.find(q)

                if (pRoot != qRoot) {
                    dp[pRoot] = qRoot
                    count--
                }
            }

            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (grid[i][j] == '1') {
                        for (k in dx.indices) {
                            val x = dx[k] + i
                            val y = dy[k] + j

                            if (x in grid.indices && y in grid[0].indices && grid[x][y] == '1') {
                                union(i * n + j, x * n + y)
                            }
                        }
                    }
                }
            }

            return count
        }

        private fun findIslandDfs(grid: Array<CharArray>, row: Int, column: Int) {
            if (row in grid.indices && column in grid[0].indices && grid[row][column] == '1') {
                grid[row][column] = 'x'

                findIslandDfs(grid, row + 1, column)
                findIslandDfs(grid, row - 1, column)
                findIslandDfs(grid, row, column + 1)
                findIslandDfs(grid, row, column - 1)
            }
        }

        private fun IntArray.find(index: Int): Int {
            var i = index

            while (this[i] != i) {
                i = this[this[i]]
            }

            return i
        }
    }

    override fun resolve() {
        println("Number Of Islands:")
        println("    Input:")
        grid.forEach {
            println("    ${it.joinToString(separator = " ")}")
        }
        println("    Result: ${numIslandsI(grid)}")
        grid.forEach {
            println("    ${it.joinToString(separator = " ")}")
        }
        println()
    }
}
