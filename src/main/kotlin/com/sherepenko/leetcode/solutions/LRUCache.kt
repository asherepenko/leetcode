package com.sherepenko.leetcode.solutions

class LRUCache(private val capacity: Int) {

    private val map = LinkedHashMap<Int, Int>(capacity)

    fun get(key: Int): Int {
        if (map.containsKey(key)) {
            val value = map[key]!!
            map.remove(key)
            map[key] = value
            return value
        }

        return -1
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            map.remove(key)
        } else if (map.size >= capacity) {
            val entry = map.iterator().next()
            map.remove(entry.key)
        }

        map[key] = value
    }
}
