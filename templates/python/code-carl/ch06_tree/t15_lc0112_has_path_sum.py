"""LeetCode 112. Path Sum
https://leetcode.cn/problems/path-sum/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        pass


if __name__ == "__main__":
    root1 = TreeNode(
        5,
        TreeNode(4, TreeNode(11, TreeNode(7), TreeNode(2))),
        TreeNode(8, TreeNode(13), TreeNode(4, None, TreeNode(1))),
    )
    solution = Solution()
    assert solution.hasPathSum(root1, 22) is True

    root2 = TreeNode(1, TreeNode(2), TreeNode(3))
    solution = Solution()
    assert solution.hasPathSum(root2, 5) is False

    solution = Solution()
    assert solution.hasPathSum(None, 0) is False
    print("All tests passed.")
