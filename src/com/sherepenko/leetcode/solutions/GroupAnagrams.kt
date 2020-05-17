package com.sherepenko.leetcode.solutions

import com.sherepenko.leetcode.Executable

class GroupAnagrams(
    private val strs: Array<String>
) : Executable {

    companion object {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val map = mutableMapOf<String, MutableList<String>>()

            strs.forEach {
                val key = it.toCharArray().sorted().joinToString("")
                if (map.containsKey(key)) {
                    map[key]?.add(it)
                } else {
                    map[key] = mutableListOf(it)
                }
            }

            return map.values.toList()
        }
    }

    override fun execute() {
        val result = groupAnagrams(strs)
        println(
            "Group Anagrams: \n" +
            "    Input: ${strs.joinToString(prefix = "[", postfix = "]")}; \n" +
            "    Result: $result \n"
        )
    }
}
