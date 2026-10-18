"""LeetCode 232. Implement Queue using Stacks
https://leetcode.cn/problems/implement-queue-using-stacks/
"""
from typing import List


class MyQueue:
    def __init__(self) -> None:
        self.stack_in: List[int] = []
        self.stack_out: List[int] = []

    def push(self, x: int) -> None:
        self.stack_in.append(x)

    def pop(self) -> int:
        if not self.stack_out:
            while self.stack_in:
                self.stack_out.append(self.stack_in.pop())
        return self.stack_out.pop()

    def peek(self) -> int:
        res = self.pop()
        self.stack_out.append(res)
        return res

    def empty(self) -> bool:
        return not self.stack_in and not self.stack_out


if __name__ == "__main__":
    queue = MyQueue()
    queue.push(1)
    queue.push(2)
    assert queue.peek() == 1
    assert queue.pop() == 1
    assert queue.empty() is False
    assert queue.pop() == 2
    assert queue.empty() is True
    print("All tests passed.")
