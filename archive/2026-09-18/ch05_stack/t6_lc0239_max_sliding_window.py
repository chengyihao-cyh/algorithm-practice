"""LeetCode 239. Sliding Window Maximum
https://leetcode.cn/problems/sliding-window-maximum/
"""

from typing import List
from collections import deque


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue: MyQueue = MyQueue()
        ans: List[int] = []

        for i in range(k):
            queue.push(nums[i])
        ans.append(queue.max())

        for i in range(k, len(nums)):
            queue.pop(nums[i - k])
            queue.push(nums[i])
            ans.append(queue.max())

        return ans


class MyQueue:
    def __init__(self):
        self.queue = deque()

    def push(self, num: int) -> None:
        while self.queue and self.queue[-1] < num:
            self.queue.pop()
        self.queue.append(num)

    def pop(self, num: int) -> None:
        if self.queue and self.queue[0] == num:
            self.queue.popleft()

    def max(self) -> int:
        return self.queue[0]


if __name__ == "__main__":
    solution = Solution()
    assert solution.maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], 3) == [3, 3, 5, 5, 6, 7]
    assert solution.maxSlidingWindow([1], 1) == [1]
    print("All tests passed.")
