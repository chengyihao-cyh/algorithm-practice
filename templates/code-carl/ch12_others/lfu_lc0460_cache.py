"""LeetCode 460. LFU Cache
https://leetcode.cn/problems/lfu-cache/
"""

from __future__ import annotations
from typing import Dict, Optional, Any


class LFUCache:
    class Entry:
        def __init__(self, key: int, value: int, freq: int) -> None:
            self.key = key
            self.value = value
            self.freq = freq
            self.pre: Optional[LFUCache.Entry] = None
            self.next: Optional[LFUCache.Entry] = None

    class EntryList:
        def __init__(self) -> None:
            self.head = LFUCache.Entry(0, 0, 0)
            self.tail = LFUCache.Entry(0, 0, 0)
            self.head.next = self.tail
            self.tail.pre = self.head
            self.size = 0

        def remove(self, entry: LFUCache.Entry) -> LFUCache.Entry:
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

        def addFirst(self, entry: LFUCache.Entry) -> None:
            first = self.head.next
            self.head.next = entry
            entry.pre = self.head
            entry.next = first
            if first is not None:
                first.pre = entry
            self.size += 1

        def removeLast(self) -> Optional[LFUCache.Entry]:
            if self.size == 0:
                return None
            return self.remove(self.tail.pre)

        def isEmpty(self) -> bool:
            return self.size == 0

    def __init__(self, capacity: int) -> None:
        self.freq_table: Dict[int, LFUCache.EntryList] = {1: LFUCache.EntryList()}
        self.key_table: Dict[int, LFUCache.Entry] = {}
        self.size = 0
        self.capacity = capacity
        self.minFreq = 0

    def get(self, key: int) -> int:
        entry = self.key_table.get(key)
        if entry is None:
            return -1
        self._remove_entry(entry)
        self._add_head_by_freq(entry)
        return entry.value

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return
        entry = self.key_table.get(key)
        if entry is not None:
            entry.value = value
            self._remove_entry(entry)
            self._add_head_by_freq(entry)
            return
        if self.size == self.capacity:
            self._remove_min_freq_tail()
        new_entry = LFUCache.Entry(key, value, 0)
        self.key_table[key] = new_entry
        self._add_head_by_freq(new_entry)
        self.minFreq = 1

    def _add_head_by_freq(self, entry: LFUCache.Entry) -> None:
        freq = entry.freq + 1
        entry.freq = freq
        self.size += 1
        lst = self.freq_table.get(freq)
        if lst is None:
            lst = LFUCache.EntryList()
            self.freq_table[freq] = lst
        lst.addFirst(entry)

    def _remove_entry(self, entry: LFUCache.Entry) -> None:
        lst = self.freq_table[entry.freq]
        lst.remove(entry)
        self.size -= 1
        if lst.isEmpty():
            self.freq_table.pop(entry.freq, None)
            if self.minFreq == entry.freq:
                self.minFreq += 1

    def _remove_min_freq_tail(self) -> Optional[LFUCache.Entry]:
        lst = self.freq_table.get(self.minFreq)
        if lst is None:
            return None
        del_entry = lst.removeLast()
        if del_entry is not None:
            self.key_table.pop(del_entry.key, None)
            self.size -= 1
        if lst.isEmpty():
            self.freq_table.pop(self.minFreq, None)
            self.minFreq += 1
        return del_entry


if __name__ == "__main__":
    cache = LFUCache(2)
    outputs: list[Any] = [None]
    cache.put(1, 1)
    outputs.append(None)
    cache.put(2, 2)
    outputs.append(None)
    outputs.append(cache.get(1))
    cache.put(3, 3)
    outputs.append(None)
    outputs.append(cache.get(2))
    outputs.append(cache.get(3))
    cache.put(4, 4)
    outputs.append(None)
    outputs.append(cache.get(1))
    outputs.append(cache.get(3))
    outputs.append(cache.get(4))

    assert outputs == [None, None, None, 1, None, -1, 3, None, -1, 3, 4]

    print("All tests passed.")
