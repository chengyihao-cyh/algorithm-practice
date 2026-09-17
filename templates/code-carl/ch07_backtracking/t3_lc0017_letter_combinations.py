"""LeetCode 17. Letter Combinations of a Phone Number
https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
"""

from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        pass


if __name__ == "__main__":
    solution = Solution()
    result = sorted(solution.letterCombinations("23"))
    expected = sorted(["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"])
    assert result == expected

    solution = Solution()
    assert solution.letterCombinations("") == []

    solution = Solution()
    assert sorted(solution.letterCombinations("2")) == ["a", "b", "c"]

    print("All tests passed.")
