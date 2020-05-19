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
