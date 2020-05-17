package com.sherepenko.leetcode.challenges

import com.sherepenko.leetcode.Executable
import com.sherepenko.leetcode.data.ListNode
import com.sherepenko.leetcode.data.TreeNode
import com.sherepenko.leetcode.solutions.*

object ThirtyDayChallenge : Executable {

    private val challenges = listOf(
        // Week 1
        object : Executable {

            private val challenges = listOf(
                SingleNumber(
                    numbers = intArrayOf(4, 1, 2, 1, 2)
                ),
                HappyNumber(
                    number = 2
                ),
                MaxSubArray(
                    numbers = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
                ),
                MoveZeroes(
                    numbers = intArrayOf(0, 1, 0, 3, 12)
                ),
                MaxProfitII(
                    prices = intArrayOf(7, 1, 5, 3, 6, 4)
                ),
                GroupAnagrams(
                    strs = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
                ),
                CountElements(
                    numbers = intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)
                ),
                BackspaceCompare(
                    strFirst = "ab##",
                    strLast = "c#d#"
                )
            )

            override fun execute() {
                println("========== Week 1 ==========")
                challenges.forEach {
                    it.execute()
                }
            }
        },

        // Week 2
        object : Executable {

            private val challenges = listOf(
                MiddleNode(
                    head = ListNode(1).apply {
                        next = ListNode(2)
                        next!!.next = ListNode(3)
                        next!!.next!!.next = ListNode(4)
                        next!!.next!!.next!!.next = ListNode(5)
                    }
                ),
                BinaryTreeDiameter(
                    root = TreeNode(1).apply {
                        left = TreeNode(2)
                        left?.left = TreeNode(4)
                        left?.right = TreeNode(5)

                        right = TreeNode(3)
                    }
                ),
                LastStoneWeight(
                    stones = intArrayOf(2, 7, 4, 1, 8, 1)
                ),
                ContiguosArray(
                    numbers = intArrayOf(0, 1, 0)
                ),
                StringShift(
                    str = "abcdefg",
                    shifts = arrayOf(
                        intArrayOf(1, 1),
                        intArrayOf(1, 1),
                        intArrayOf(0, 2),
                        intArrayOf(1, 3)
                    )
                )
            )

            override fun execute() {
                println("========== Week 2 ==========")
                challenges.forEach {
                    it.execute()
                }
            }
        },

        // Week 3
        object : Executable {

            private val challenges = listOf(
                ProductOfArrayExceptSelf(
                    numbers = intArrayOf(1, 2, 3, 4)
                ),
                ValidParenthesisString(
                    str = "(*))"
                ),
                NumberOfIslands(
                    grid = arrayOf(
                        "11000".toCharArray(),
                        "11000".toCharArray(),
                        "00100".toCharArray(),
                        "00011".toCharArray()
                    )
                ),
                MinPathSum(
                    grid = arrayOf(
                        intArrayOf(1, 3, 1),
                        intArrayOf(1, 5, 1),
                        intArrayOf(4, 2, 1)
                    )
                ),
                RotatedSortedArray(
                    numbers = intArrayOf(4, 5, 6, 7, 0, 1, 2),
                    target = 2
                ),
                BinaryTreePreorderTraversal(
                    values = intArrayOf(8, 5, 1, 7, 10, 12)
                )
            )

            override fun execute() {
                println("========== Week 3 ==========")
                challenges.forEach {
                    it.execute()
                }
            }
        },

        // Week 4
        object : Executable {

            private val challenges = listOf(
                SubArraySum(
                    numbers = intArrayOf(1, 1, 1),
                    value = 2
                ),
                RangeBitwiseAnd(
                    first = 5,
                    last = 7
                ),
                JumpGame(
                    numbers = intArrayOf(3, 2, 1, 0, 4)
                ),
                LongestCommonSubsequence(
                    text1 = "abcde",
                    text2 = "face"
                ),
                MaximalSquare(
                    matrix = arrayOf(
                        "11100".toCharArray(),
                        "11100".toCharArray(),
                        "00100".toCharArray(),
                        "00011".toCharArray()
                    )
                )
            )

            override fun execute() {
                println("========== Week 4 ==========")
                challenges.forEach {
                    it.execute()
                }
            }
        },

        // Week 5
        object : Executable {

            val challenges = emptyList<Executable>()

            override fun execute() {
                println("========== Week 5 ==========")
                challenges.forEach {
                    it.execute()
                }
            }
        }
    )

    override fun execute() {
        println("========== 30  D A Y  C H A L L E N G E ==========")
        challenges.forEach {
            it.execute()
        }
    }
}
