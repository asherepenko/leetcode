package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable

class MaxProfitII(
    private val prices: IntArray
) : Executable {

    companion object {
        fun maxProfit(prices: IntArray): Int {
            var profit = 0

            for (i in 0 until prices.lastIndex) {
                val diff = prices[i + 1] - prices[i]
                if (diff > 0) {
                    profit += diff
                }
            }

            return profit
        }
    }

    override fun execute() {
        val result = maxProfit(prices)

        println(
            "Best Time to Buy and Sell Stock: \n" +
            "    Input: ${prices.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: $result \n"
        )
    }
}
