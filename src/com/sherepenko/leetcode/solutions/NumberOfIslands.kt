package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable

class NumberOfIslands(
    private val grid: Array<CharArray>
) : Executable {

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
            val dx = intArrayOf(-1, 1, 0, 0)
            val dy = intArrayOf(0, 0, -1, 1)

            val matrix = IntArray(m * n)

            var count = 0

            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (grid[i][j] == '1') {
                        matrix[i * n + j] = i * n + j
                        count++
                    }
                }
            }

            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (grid[i][j] == '1') {
                        for (k in dx.indices) {
                            val x = dx[k] + i
                            val y = dy[k] + j

                            if (x in grid.indices && y in grid[0].indices && grid[x][y] == '1') {
                                val pRoot = matrix.root(i * n + j)
                                val qRoot = matrix.root(x * n + y)

                                if (pRoot != qRoot) {
                                    matrix[pRoot] = qRoot
                                    count--
                                }
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

        private fun IntArray.root(index: Int): Int {
            var i = index

            while (this[i] != i) {
                i = this[this[i]]
            }

            return i
        }
    }

    override fun execute() {
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
