"""LeetCode 225. Implement Stack using Queues
https://leetcode.cn/problems/implement-stack-using-queues/
"""


class MyStack:
    def __init__(self) -> None:
        pass

    def push(self, x: int) -> None:
        pass

    def pop(self) -> int:
        pass

    def top(self) -> int:
        pass

    def empty(self) -> bool:
        pass


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
