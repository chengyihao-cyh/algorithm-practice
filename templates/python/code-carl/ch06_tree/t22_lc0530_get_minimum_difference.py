"""LeetCode 530. Minimum Absolute Difference in BST
https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def getMinimumDifference(self, root: Optional[TreeNode]) -> int:
        pass


if __name__ == "__main__":
    solution = Solution()
    root1 = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(6))
    assert solution.getMinimumDifference(root1) == 1

    solution = Solution()
    root2 = TreeNode(1, TreeNode(0), TreeNode(48, TreeNode(12), TreeNode(49)))
    assert solution.getMinimumDifference(root2) == 1

    print("All tests passed.")
