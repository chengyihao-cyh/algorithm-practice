"""LeetCode 104. Maximum Depth of Binary Tree
https://leetcode.cn/problems/maximum-depth-of-binary-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        pass


if __name__ == "__main__":
    root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    solution = Solution()
    assert solution.maxDepth(root) == 3
    solution = Solution()
    assert solution.maxDepth(None) == 0
    print("All tests passed.")
