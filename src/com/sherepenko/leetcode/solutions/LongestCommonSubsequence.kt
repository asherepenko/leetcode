package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable
import kotlin.math.max

class LongestCommonSubsequence(
    private val text1: String,
    private val text2: String
) : Executable {

    companion object {
        fun longestCommonSubsequence(text1: String, text2: String): Int {
            val m = text1.length + 1
            val n = text2.length + 1

            val dp = Array(m) {
                IntArray(n)
            }

            for (i in 0 until m) {
                for (j in 0 until n) {
                    dp[i][j] = if (i == 0 || j == 0) {
                        0
                    } else if (text1[i - 1] == text2[j - 1]) {
                        dp[i - 1][j - 1] + 1
                    } else {
                        max(dp[i - 1][j], dp[i][j - 1])
                    }
                }
            }

            return dp[m - 1][n - 1]
        }
    }

    override fun execute() {
        val result = longestCommonSubsequence(text1, text2)

        println(
            "Longest Common Subsequence: \n" +
            "    Input: $text1, $text2; \n" +
            "    Result: $result \n"
        )
    }
}
