"""LeetCode 404. Sum of Left Leaves
https://leetcode.cn/problems/sum-of-left-leaves/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        pass


if __name__ == "__main__":
    root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    solution = Solution()
    assert solution.sumOfLeftLeaves(root) == 24
    solution = Solution()
    assert solution.sumOfLeftLeaves(None) == 0
    print("All tests passed.")
