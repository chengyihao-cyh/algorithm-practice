"""LeetCode 513. Find Bottom Left Tree Value
https://leetcode.cn/problems/find-bottom-left-tree-value/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        pass


if __name__ == "__main__":
    root1 = TreeNode(2, TreeNode(1), TreeNode(3))
    solution = Solution()
    assert solution.findBottomLeftValue(root1) == 1

    root2 = TreeNode(
        1, TreeNode(2, TreeNode(4)), TreeNode(3, TreeNode(5, TreeNode(7)), TreeNode(6))
    )
    solution = Solution()
    assert solution.findBottomLeftValue(root2) == 7

    print("All tests passed.")
