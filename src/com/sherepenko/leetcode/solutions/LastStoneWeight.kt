package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import java.util.*

class LastStoneWeight(
    private val stones: IntArray
) : Solution {

    companion object {
        fun lastStoneWeight(stones: IntArray): Int {
            val queue = PriorityQueue<Int>(Collections.reverseOrder())

            stones.forEach {
                queue.add(it)
            }

            while (queue.size > 1) {
                val diff = queue.poll() - queue.poll()
                if (diff != 0) {
                    queue.add(diff)
                }
            }

            return if (!queue.isEmpty()) {
                queue.poll()
            } else {
                0
            }
        }
    }

    override fun resolve() {
        val result = lastStoneWeight(stones)
        println(
            "Last Stone Weight: \n" +
            "    Input: ${stones.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: $result \n"
        )
    }
}
