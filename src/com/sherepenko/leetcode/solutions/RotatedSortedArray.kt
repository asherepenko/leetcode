package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Solution

class RotatedSortedArray(
    private val numbers: IntArray,
    private val target: Int
) : Solution {

    companion object {
        fun search(numbers: IntArray, target: Int): Int {
            var left = 0
            var right = numbers.lastIndex

            while (left <= right) {
                val mid: Int = left + (right - left) / 2

                if (numbers[mid] == target) {
                    return mid
                }

                if (numbers[left] <= numbers[mid]) {
                    if (numbers[left] <= target && target < numbers[mid]) {
                        right = mid - 1
                    } else {
                        left = mid + 1
                    }
                } else {
                    if (numbers[mid] < target && target <= numbers[right]) {
                        left = mid + 1
                    } else {
                        right = mid - 1
                    }
                }
            }

            return -1
        }
    }

    override fun resolve() {
        val result = search(numbers, target)

        println(
            "Search in Rotated Sorted Array: \n" +
            "    Input: ${numbers.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: $result \n"
        )
    }
}
