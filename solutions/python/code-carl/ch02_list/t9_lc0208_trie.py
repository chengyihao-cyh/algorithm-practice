"""LeetCode 208. Implement Trie (Prefix Tree)
https://leetcode.cn/problems/implement-trie-prefix-tree/
"""
from typing import List, Optional


class Trie:
    def __init__(self) -> None:
        self.root = Node()

    def insert(self, word: str) -> None:
        curr = self.root
        for ch in word:
            idx = ord(ch) - ord("a")
            child = curr.children[idx]
            if child is None:
                child = Node()
                curr.children[idx] = child
            curr = child
            curr.val = ch
        curr.is_end = True

    def search(self, word: str) -> bool:
        curr = self.root
        for ch in word:
            idx = ord(ch) - ord("a")
            child = curr.children[idx]
            if child is None:
                return False
            curr = child
        return curr.is_end

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for ch in prefix:
            idx = ord(ch) - ord("a")
            child = curr.children[idx]
            if child is None:
                return False
            curr = child
        return True


class Node:
    def __init__(self, val: str = "", is_end: bool = False, children: Optional[List[Optional["Node"]]] = None):
        if children is None:
            children = [None for _ in range(26)]
        self.val = val
        self.is_end = is_end
        self.children = children


if __name__ == "__main__":
    trie = Trie()
    trie.insert("apple")
    assert trie.search("apple") is True
    assert trie.search("app") is False
    assert trie.startsWith("app") is True
    trie.insert("app")
    assert trie.search("app") is True
    print("All tests passed.")
