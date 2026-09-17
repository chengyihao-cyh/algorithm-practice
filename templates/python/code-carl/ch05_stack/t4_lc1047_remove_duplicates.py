"""LeetCode 1047. Remove All Adjacent Duplicates In String
https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
"""


class Solution:
    def removeDuplicates(self, s: str) -> str:
        pass


if __name__ == "__main__":
    solution = Solution()
    assert solution.removeDuplicates("abbaca") == "ca"
    assert solution.removeDuplicates("azxxzy") == "ay"
    print("All tests passed.")
