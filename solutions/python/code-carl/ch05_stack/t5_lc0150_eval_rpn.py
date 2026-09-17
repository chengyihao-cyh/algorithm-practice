"""LeetCode 150. Evaluate Reverse Polish Notation
https://leetcode.cn/problems/evaluate-reverse-polish-notation/
"""

from typing import List


class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack: List[int] = []
        for token in tokens:
            if token.strip('-').isdigit():
                stack.append(int(token))
            elif token == '+':
                stack.append(stack.pop() + stack.pop())
            elif token == '-':
                stack.append(- stack.pop() + stack.pop())
            elif token == '*':
                stack.append(stack.pop() * stack.pop())
            elif token == '/':
                n2, n1 = stack.pop(), stack.pop()
                stack.append(int(n1 / float(n2)))
        return stack.pop()


if __name__ == "__main__":
    solution = Solution()
    assert solution.evalRPN(["2", "1", "+", "3", "*"]) == 9
    assert solution.evalRPN(["4", "13", "5", "/", "+"]) == 6
    assert solution.evalRPN(["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]) == 22
    print("All tests passed.")
