"""LeetCode 20. Valid Parentheses
https://leetcode.cn/problems/valid-parentheses/
"""
from typing import List


class Solution:
    def isValid(self, s: str) -> bool:
        stack: List[str] = []
        for ch in s:
            if ch == '{':
                stack.append('}')
            elif ch == '[':
                stack.append(']')
            elif ch == '(':
                stack.append(')')
            elif not stack or ch != stack[-1]:
                return False
            else:
                stack.pop()

        return True


if __name__ == "__main__":
    solution = Solution()
    assert solution.isValid("([])") is True
    assert solution.isValid("()[]{}") is True
    assert solution.isValid("(]") is False
    print("All tests passed.")
