"""LeetCode 232. Implement Queue using Stacks
https://leetcode.cn/problems/implement-queue-using-stacks/
"""


class MyQueue:
    def __init__(self) -> None:
        self.s_in = []
        self.s_out = []

    def push(self, x: int) -> None:
        self.s_in.append(x)

    def pop(self) -> int:
        if not self.s_out:
            while self.s_in:
                self.s_out.append(self.s_in.pop())
        return -1 if not self.s_out else self.s_out.pop()

    def peek(self) -> int:
        p = self.pop()
        self.s_out.append(p)
        return p

    def empty(self) -> bool:
        return not self.s_in and not self.s_out


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
