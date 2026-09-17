"""LeetCode 20. Valid Parentheses
https://leetcode.cn/problems/valid-parentheses/
"""


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        dic = {'(': ')', '[': ']', '{': '}'}
        for ch in s:
            if ch in dic:
                stack.append(dic[ch])
            else:
                if not stack or ch != stack.pop():
                    return False
        return not stack


if __name__ == "__main__":
    solution = Solution()
    assert solution.isValid("()") is True
    assert solution.isValid("()[]{}") is True
    assert solution.isValid("(]") is False
    print("All tests passed.")
