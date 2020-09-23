package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import kotlin.math.max

class LongestPalindromicSubstring(
    private val str: String
) : Solution {

    companion object {
        fun longestPalindrome(str: String): String? {
            if (str.length <= 1) {
                return str
            }

            val dp = Array(str.length) {
                IntArray(str.length)
            }

            var maxLength = 0
            var start = 0
            var end = 0

            for (j in str.indices) {
                dp[j][j] = 1
                for (i in 0 until j) {
                    if (str[i] == str[j] && (j - i <= 2 || dp[i + 1][j - 1] == 1)) {
                        dp[i][j] = 1

                        if (j - i + 1 > maxLength) {
                            maxLength = j - i + 1
                            start = i
                            end = j
                        }
                    }
                }
            }

            dp.forEach {
                println("    ${it.joinToString(separator = " ")}")
            }

            return str.substring(start..end)
        }

        fun longestPalindromeII(str: String): String? {
            if (str.length <= 1) {
                return str
            }

            var start = 0
            var end = 0

            for (i in str.indices) {
                val length = max(
                    str.expand(i, i),
                    str.expand(i, i + 1)
                )

                if (length > end - start) {
                    start = i - (length - 1) / 2
                    end = i + length / 2
                }
            }

            return str.substring(start..end)
        }

        private fun String.expand(start: Int, end: Int): Int {
            var i = start
            var j = end

            while (i >= 0 && j < length && this[i] == this[j]) {
                i--
                j++
            }

            return j - i - 1
        }
    }

    override fun resolve() {
        val result = longestPalindrome(str)

        println(
            "Longest Palindromic Substring: \n" +
                "    Input: $str; \n" +
                "    Result: $result \n"
        )
    }
}
