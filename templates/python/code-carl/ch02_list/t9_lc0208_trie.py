"""LeetCode 208. Implement Trie (Prefix Tree)
https://leetcode.cn/problems/implement-trie-prefix-tree/
"""


class Trie:
    def __init__(self) -> None:
        pass

    def insert(self, word: str) -> None:
        pass

    def search(self, word: str) -> bool:
        pass

    def startsWith(self, prefix: str) -> bool:
        pass


if __name__ == "__main__":
    trie = Trie()
    trie.insert("apple")
    assert trie.search("apple") is True
    assert trie.search("app") is False
    assert trie.startsWith("app") is True
    trie.insert("app")
    assert trie.search("app") is True
    print("All tests passed.")
