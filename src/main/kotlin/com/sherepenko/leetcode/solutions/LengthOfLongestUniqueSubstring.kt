package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import kotlin.math.max

class LengthOfLongestUniqueSubstring(
    private val str: String
) : Solution {

    companion object {
        fun lengthOfLongestSubstring(str: String): Int {
            val indices = mutableMapOf<Char, Int>()
            var start = 0
            var length = 0

            for ((end, value) in str.withIndex()) {
                start = max(start, indices.getOrDefault(value, 0))
                length = max(length, end - start + 1)
                indices[value] = end + 1
            }

            return length
        }

        fun lengthOfLongestSubstringBf(str: String): Int {
            var length = 0

            for (i in str.indices) {
                for (j in (i + 1)..str.length) {
                    if (str.unique(i, j)) {
                        length = max(length, j - i)
                    }
                }
            }

            return length
        }

        private fun String.unique(start: Int, end: Int): Boolean {
            val set = mutableSetOf<Char>()

            for (i in start until end) {
                if (set.contains(this[i])) {
                    return false
                }
                set.add(this[i])
            }

            return true
        }
    }

    override fun resolve() {
        val result = lengthOfLongestSubstring(str)
        println(
            "Length of Longest Substring: \n" +
            "    Input: $str; \n" +
            "    Result: $result \n"
        )
    }
}
