"""LeetCode 127. Word Ladder
https://leetcode.cn/problems/word-ladder/
"""

from typing import List


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.ladderLength("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]) == 5
    assert solution.ladderLength("hit", "cog", ["hot", "dot", "dog", "lot", "log"]) == 0

    print("All tests passed.")
