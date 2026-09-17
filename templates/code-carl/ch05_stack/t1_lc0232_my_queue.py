"""LeetCode 232. Implement Queue using Stacks
https://leetcode.cn/problems/implement-queue-using-stacks/
"""


class MyQueue:
    def __init__(self) -> None:
        pass

    def push(self, x: int) -> None:
        pass

    def pop(self) -> int:
        pass

    def peek(self) -> int:
        pass

    def empty(self) -> bool:
        pass


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
