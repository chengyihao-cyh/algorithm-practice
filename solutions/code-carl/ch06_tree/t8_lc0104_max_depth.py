"""LeetCode 104. Maximum Depth of Binary Tree
https://leetcode.cn/problems/maximum-depth-of-binary-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1


if __name__ == "__main__":
    solution = Solution()
    root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    assert solution.maxDepth(root) == 3
    assert solution.maxDepth(None) == 0
    print("All tests passed.")
