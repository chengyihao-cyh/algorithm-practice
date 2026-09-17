"""LeetCode 654. Maximum Binary Tree
https://leetcode.cn/problems/maximum-binary-tree/
"""

from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        if not nums:
            return None

        def build(nums: List[int], start: int, end: int) -> Optional[TreeNode]:
            if start == end:
                return None
            elif start == end - 1:
                return TreeNode(val=nums[start])

            max_val: int = nums[start]
            max_idx: int = start
            for i in range(start + 1, end):
                if nums[i] > max_val:
                    max_val, max_idx = nums[i], i

            root = TreeNode(val=max_val)
            root.left = build(nums, start, max_idx)
            root.right = build(nums, max_idx + 1, end)
            return root

        return build(nums, 0, len(nums))


if __name__ == "__main__":
    solution = Solution()
    root1 = solution.constructMaximumBinaryTree([3, 2, 1, 6, 0, 5])
    assert root1.val == 6
    assert root1.left.val == 3
    assert root1.left.right.val == 2
    assert root1.left.right.right.val == 1
    assert root1.right.val == 5
    assert root1.right.left.val == 0

    root2 = solution.constructMaximumBinaryTree([3, 2, 1])
    assert root2.val == 3
    assert root2.right.val == 2
    assert root2.right.right.val == 1
    print("All tests passed.")
