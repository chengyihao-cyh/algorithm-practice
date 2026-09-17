"""LeetCode 139. Word Break
https://leetcode.cn/problems/word-break/
"""

from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        pass

if __name__ == "__main__":
    solution = Solution()
    assert solution.wordBreak('leetcode', ['leet', 'code']) == True
    assert solution.wordBreak('applepenapple', ['apple', 'pen']) == True
    assert solution.wordBreak('catsandog', ['cats', 'dog', 'sand', 'and', 'cat']) == False
    print("All tests passed.")
