package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import kotlin.math.max

class LongestCommonSubstring(
    private val text1: String,
    private val text2: String
) : Solution {

    companion object {
        fun longestCommonSubsequence(text1: String, text2: String): Int {
            val m = text1.length
            val n = text2.length

            val dp = Array(m) {
                IntArray(n)
            }

            var result = 0

            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (text1[i] == text2[j]) {
                        dp[i][j] = if (i == 0 || j == 0) {
                            1
                        } else {
                            dp[i - 1][j - 1] + 1
                        }
                    }

                    result = max(result, dp[i][j])
                }
            }

            return result
        }
    }

    override fun resolve() {
        val result = longestCommonSubsequence(text1, text2)

        println(
            "Longest Common Substring: \n" +
                "    Input: $text1, $text2; \n" +
                "    Result: $result \n"
        )
    }
}
