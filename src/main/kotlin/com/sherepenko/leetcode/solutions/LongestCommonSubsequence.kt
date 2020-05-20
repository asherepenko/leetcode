package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import kotlin.math.max

class LongestCommonSubsequence(
    private val text1: String,
    private val text2: String
) : Solution {

    companion object {
        fun longestCommonSubsequence(text1: String, text2: String): Int {
            val m = text1.length
            val n = text2.length

            val dp = Array(m + 1) {
                IntArray(n + 1)
            }

            for (i in 0..m) {
                for (j in 0..n) {
                    dp[i][j] = if (i == 0 || j == 0) {
                        0
                    } else if (text1[i - 1] == text2[j - 1]) {
                        dp[i - 1][j - 1] + 1
                    } else {
                        max(dp[i - 1][j], dp[i][j - 1])
                    }
                }
            }

            return dp[m][n]
        }
    }

    override fun resolve() {
        val result = longestCommonSubsequence(text1, text2)

        println(
            "Longest Common Subsequence: \n" +
            "    Input: $text1, $text2; \n" +
            "    Result: $result \n"
        )
    }
}
