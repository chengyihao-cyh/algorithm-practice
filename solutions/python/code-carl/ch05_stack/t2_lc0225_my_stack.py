"""LeetCode 225. Implement Stack using Queues
https://leetcode.cn/problems/implement-stack-using-queues/
"""
from collections import deque


class MyStack:
    def __init__(self) -> None:
        self.q = deque()
        self.q_tmp = deque()

    def push(self, x: int) -> None:
        self.q.append(x)

    def pop(self) -> int:
        if not self.q:
            return -1
        while len(self.q) != 1:
            self.q_tmp.append(self.q.popleft())
        p = self.q.pop()
        self.q, self.q_tmp = self.q_tmp, self.q
        return p

    def top(self) -> int:
        p = self.pop()
        self.q.append(p)
        return p

    def empty(self) -> bool:
        return not self.q


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
