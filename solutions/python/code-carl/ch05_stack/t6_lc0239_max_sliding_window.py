"""LeetCode 239. Sliding Window Maximum
https://leetcode.cn/problems/sliding-window-maximum/
"""
from collections import deque
from typing import List


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        myQueue = MyQueue()
        ans = []
        for i in range(0, k):
            myQueue.push(nums[i])
        ans.append(myQueue.getMax())

        for i in range(k, len(nums)):
            myQueue.remove(nums[i - k])
            myQueue.push(nums[i])
            ans.append(myQueue.getMax())

        return ans


class MyQueue:
    def __init__(self):
        self.deque = deque()

    def push(self, x: int) -> None:
        while self.deque and self.deque[-1] < x:
            self.deque.pop()
        self.deque.append(x)

    def getMax(self) -> int:
        return self.deque[0]

    def remove(self, x: int) -> None:
        if self.deque and x == self.deque[0]:
            self.deque.popleft()


if __name__ == "__main__":
    solution = Solution()
    assert solution.maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], 3) == [3, 3, 5, 5, 6, 7]
    assert solution.maxSlidingWindow([1], 1) == [1]
    assert solution.maxSlidingWindow([1, -1], 1) == [1, -1]
    print("All tests passed.")
