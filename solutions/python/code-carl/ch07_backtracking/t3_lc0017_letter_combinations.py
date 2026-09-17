"""LeetCode 17. Letter Combinations of a Phone Number
https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
"""

from typing import List, Dict


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        dic: Dict[str, str] = {"2": "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv",
                               "9": "wxyz"}
        path: List[str] = []
        ans: List[str] = []

        def backtracking(num_str: str, idx: int) -> None:
            if idx == len(num_str):
                ans.append("".join(path))
                return
            candidates = dic.get(num_str[idx], "")
            for ch in candidates:
                path.append(ch)
                backtracking(num_str, idx + 1)
                path.pop()

        if digits:
            backtracking(digits, 0)
        return ans


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
