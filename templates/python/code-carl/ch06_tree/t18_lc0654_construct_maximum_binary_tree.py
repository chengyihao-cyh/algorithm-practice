"""LeetCode 654. Maximum Binary Tree
https://leetcode.cn/problems/maximum-binary-tree/
"""

from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        pass


if __name__ == "__main__":
    solution = Solution()
    root1 = solution.constructMaximumBinaryTree([3, 2, 1, 6, 0, 5])
    assert root1.val == 6
    assert root1.left.val == 3
    assert root1.left.right.val == 2
    assert root1.left.right.right.val == 1
    assert root1.right.val == 5
    assert root1.right.left.val == 0

    solution = Solution()
    root2 = solution.constructMaximumBinaryTree([3, 2, 1])
    assert root2.val == 3
    assert root2.right.val == 2
    assert root2.right.right.val == 1
    print("All tests passed.")
