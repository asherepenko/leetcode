package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable
import kotlin.math.max

class JumpGame(
    private val numbers: IntArray
) : Executable {

    companion object {
        fun canJump(numbers: IntArray): Boolean {
            if (numbers.size <= 1) {
                return true
            }

            var maxJump = numbers[0]

            for (i in numbers.indices) {
                if (maxJump <= i && numbers[i] == 0) {
                    return false
                }

                maxJump = max(maxJump, i + numbers[i])

                if (maxJump >= numbers.lastIndex) {
                    return true
                }
            }

            return false
        }

        fun canJumpII(numbers: IntArray): Boolean {
            var lastIndex = numbers.lastIndex

            for (i in numbers.lastIndex downTo 0) {
                if (i + numbers[i] >= lastIndex) {
                    lastIndex = i
                }
            }

            return lastIndex == 0
        }
    }

    override fun execute() {
        val result = canJump(numbers)

        println(
            "Jump Game: \n" +
            "    Input: ${numbers.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: $result \n"
        )
    }
}
