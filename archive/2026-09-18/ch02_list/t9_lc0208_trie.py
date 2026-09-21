"""LeetCode 208. Implement Trie (Prefix Tree)
https://leetcode.cn/problems/implement-trie-prefix-tree/
"""
from math import fabs
from os.path import curdir
from typing import List, Optional


class _TrieNode:
    def __init__(self):
        self.children: List[Optional["_TrieNode"]] = [None] * 26
        self.is_end = False


class Trie:

    def __init__(self) -> None:
        self.root = _TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for ch in word:
            if not curr.children[ord(ch) - ord("a")]:
                curr.children[ord(ch) - ord("a")] = _TrieNode()
            curr = curr.children[ord(ch) - ord("a")]
        curr.is_end = True

    def search(self, word: str) -> bool:
        curr = self.root
        for ch in word:
            if not curr.children[ord(ch) - ord("a")]:
                return False
            curr = curr.children[ord(ch) - ord("a")]

        return curr.is_end

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for ch in prefix:
            if not curr.children[ord(ch) - ord("a")]:
                return False
            curr = curr.children[ord(ch) - ord("a")]

        return True


if __name__ == "__main__":
    trie = Trie()
    trie.insert("apple")
    assert trie.search("apple") is True
    assert trie.search("app") is False
    assert trie.startsWith("app") is True
    trie.insert("app")
    assert trie.search("app") is True
    print("All tests passed.")
