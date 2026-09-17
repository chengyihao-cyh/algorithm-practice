"""LeetCode 404. Sum of Left Leaves
https://leetcode.cn/problems/sum-of-left-leaves/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        if not root or not root.left and not root.right:
            return 0

        if root.left and not root.left.left and not root.left.right:
            left = root.left.val
        else:
            left = self.sumOfLeftLeaves(root.left)

        return left + self.sumOfLeftLeaves(root.right)


if __name__ == "__main__":
    solution = Solution()
    root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    assert solution.sumOfLeftLeaves(root) == 24
    assert solution.sumOfLeftLeaves(None) == 0
    print("All tests passed.")
