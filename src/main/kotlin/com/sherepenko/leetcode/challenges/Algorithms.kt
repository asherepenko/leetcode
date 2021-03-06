package com.sherepenko.leetcode.challenges

import com.sherepenko.leetcode.Solution
import com.sherepenko.leetcode.data.ListNode
import com.sherepenko.leetcode.solutions.AddTwoNumbers
import com.sherepenko.leetcode.solutions.Fibonacci
import com.sherepenko.leetcode.solutions.LengthOfLongestUniqueSubstring
import com.sherepenko.leetcode.solutions.LongestCommonSubstring
import com.sherepenko.leetcode.solutions.LongestPalindromicSubstring
import com.sherepenko.leetcode.solutions.OddEvenList
import com.sherepenko.leetcode.solutions.Palindrome
import com.sherepenko.leetcode.solutions.ReverseLinkedList
import com.sherepenko.leetcode.solutions.TwoSum

object Algorithms : Solution {

    private val challenges = listOf(
        TwoSum(
            numbers = intArrayOf(2, 7, 11, 15),
            target = 9
        ),
        AddTwoNumbers(
            head1 = ListNode(2).apply {
                next = ListNode(4)
                next!!.next = ListNode(3)
            },
            head2 = ListNode(5).apply {
                next = ListNode(6)
                next!!.next = ListNode(4)
            }
        ),
        LengthOfLongestUniqueSubstring(
            str = "abcabcbb"
        ),
        ReverseLinkedList(
            head = ListNode(1).apply {
                next = ListNode(2)
                next!!.next = ListNode(3)
                next!!.next!!.next = ListNode(4)
                next!!.next!!.next!!.next = ListNode(5)
            }
        ),
        OddEvenList(
            head = ListNode(1).apply {
                next = ListNode(2)
                next!!.next = ListNode(3)
                next!!.next!!.next = ListNode(4)
                next!!.next!!.next!!.next = ListNode(5)
            }
        ),
        Palindrome(
            str = "test"
        ),
        Fibonacci(
            number = 10
        ),
        LongestCommonSubstring(
            text1 = "abc",
            text2 = "fabcd"
        ),
        LongestPalindromicSubstring(
            str = "babbad"
        )
    )

    override fun resolve() {
        println("========== A L G O R I T H M S ==========")
        challenges.forEach {
            it.resolve()
        }
    }
}
