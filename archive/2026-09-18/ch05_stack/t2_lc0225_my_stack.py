"""LeetCode 225. Implement Stack using Queues
https://leetcode.cn/problems/implement-stack-using-queues/
"""
from collections import deque
from typing import Deque


class MyStack:
    def __init__(self) -> None:
        self.stack: Deque[int] = deque()

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        for _ in range(len(self.stack) - 1):
            self.stack.append(self.stack.popleft())
        return self.stack.popleft()

    def top(self) -> int:
        res = self.pop()
        self.push(res)
        return res

    def empty(self) -> bool:
        return len(self.stack) == 0


if __name__ == "__main__":
    stack = MyStack()
    stack.push(1)
    stack.push(2)
    assert stack.top() == 2
    assert stack.pop() == 2
    assert stack.empty() is False
    assert stack.pop() == 1
    assert stack.empty() is True
    print("All tests passed.")
