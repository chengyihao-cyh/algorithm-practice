"""LeetCode 146. LRU Cache
https://leetcode.cn/problems/lru-cache/
"""

from __future__ import annotations
from typing import Dict, Optional, Any


class LRUCache:
    class Entry:
        def __init__(self, key: int, value: int) -> None:
            self.key = key
            self.value = value
            self.pre: Optional[LRUCache.Entry] = None
            self.next: Optional[LRUCache.Entry] = None

    class EntryList:
        def __init__(self) -> None:
            self.head = LRUCache.Entry(-1, -1)
            self.tail = LRUCache.Entry(-1, -1)
            self.head.next = self.tail
            self.tail.pre = self.head
            self.size = 0

        def addFirst(self, entry: LRUCache.Entry) -> None:
            first = self.head.next
            self.head.next = entry
            entry.pre = self.head
            entry.next = first
            if first is not None:
                first.pre = entry
            self.size += 1

        def remove(self, entry: LRUCache.Entry) -> LRUCache.Entry:
            pre = entry.pre
            nxt = entry.next
            if pre is not None:
                pre.next = nxt
            if nxt is not None:
                nxt.pre = pre
            entry.pre = None
            entry.next = None
            self.size -= 1
            return entry

        def removeLast(self) -> Optional[LRUCache.Entry]:
            if self.size == 0:
                return None
            return self.remove(self.tail.pre)

    def __init__(self, capacity: int) -> None:
        self.key_table: Dict[int, LRUCache.Entry] = {}
        self.capacity = capacity
        self.entryList = LRUCache.EntryList()

    def get(self, key: int) -> int:
        entry = self.key_table.get(key)
        if entry is None:
            return -1
        self.entryList.remove(entry)
        self.entryList.addFirst(entry)
        return entry.value

    def put(self, key: int, value: int) -> None:
        entry = self.key_table.get(key)
        if entry is not None:
            entry.value = value
            self.entryList.remove(entry)
            self.entryList.addFirst(entry)
            return
        new_entry = LRUCache.Entry(key, value)
        self.entryList.addFirst(new_entry)
        self.key_table[key] = new_entry
        if self.entryList.size > self.capacity:
            old_tail = self.entryList.removeLast()
            if old_tail is not None:
                self.key_table.pop(old_tail.key, None)


if __name__ == "__main__":
    cache = LRUCache(2)
    outputs: list[Any] = [None]
    cache.put(1, 1)
    outputs.append(None)
    cache.put(2, 2)
    outputs.append(None)
    outputs.append(cache.get(1))
    cache.put(3, 3)
    outputs.append(None)
    outputs.append(cache.get(2))
    cache.put(4, 4)
    outputs.append(None)
    outputs.append(cache.get(1))
    outputs.append(cache.get(3))
    outputs.append(cache.get(4))

    assert outputs == [None, None, None, 1, None, -1, None, -1, 3, 4]

    print("All tests passed.")
