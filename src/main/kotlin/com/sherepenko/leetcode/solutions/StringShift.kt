package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution
import kotlin.math.abs

class StringShift(
    private val str: String,
    private val shifts: Array<IntArray>
) : Solution {

    companion object {
        fun stringShift(str: String, shifts: Array<IntArray>): String {
            var shift = 0

            shifts.forEach {
                shift += if (it[0] == 1) it[1] else -it[1]
            }

            shift %= str.length

            return when {
                shift > 0 -> {
                    str.shift(str.length - shift)
                }
                shift < 0 -> {
                    str.shift(abs(shift))
                }
                else -> {
                    str
                }
            }
        }

        private fun String.shift(offset: Int): String =
            substring(offset) + substring(0, offset)
    }

    override fun resolve() {
        val result = stringShift(str, shifts)

        println(
            "Perform String Shifts: \n" +
                "    Input: $str, ${shifts.joinToString(
                    prefix = "[",
                    postfix = "]"
                ) { it.joinToString(prefix = "[", postfix = "]") }}; \n" +
                "    Result: $result \n"
        )
    }
}
