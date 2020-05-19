package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class Palindrome(
    private val str: String
) : Solution {

    companion object {
        fun isPalindrome(str: String): Boolean {
            for (i in 0 until str.length / 2) {
                if (str[i] != str[str.length - i - 1]) {
                    return false
                }
            }

            return true
        }
    }

    override fun resolve() {
        val result = isPalindrome(str)
        println(
            "Palindrome String: \n" +
            "    Input: $str; \n" +
            "    Result: $result \n"
        )
    }
}
