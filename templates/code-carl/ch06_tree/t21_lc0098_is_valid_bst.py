"""LeetCode 98. Validate Binary Search Tree
https://leetcode.cn/problems/validate-binary-search-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        pass


if __name__ == "__main__":
    solution = Solution()
    root1 = TreeNode(2, TreeNode(1), TreeNode(3))
    assert solution.isValidBST(root1) is True

    solution = Solution()
    root2 = TreeNode(5, TreeNode(1), TreeNode(4, TreeNode(3), TreeNode(6)))
    assert solution.isValidBST(root2) is False

    print("All tests passed.")
