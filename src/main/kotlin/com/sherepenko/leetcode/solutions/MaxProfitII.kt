package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class MaxProfitII(
    private val prices: IntArray
) : Solution {

    companion object {
        fun maxProfit(prices: IntArray): Int {
            var profit = 0

            for (i in 1 until prices.size) {
                val diff = prices[i] - prices[i - 1]
                if (diff > 0) {
                    profit += diff
                }
            }

            return profit
        }
    }

    override fun resolve() {
        val result = maxProfit(prices)

        println(
            "Best Time to Buy and Sell Stock: \n" +
                "    Input: ${prices.joinToString(prefix = "[", postfix = "]")}; \n" +
                "    Result: $result \n"
        )
    }
}
