"""LeetCode 501. Find Mode in Binary Search Tree
https://leetcode.cn/problems/find-mode-in-binary-search-tree/
"""

from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        pass


if __name__ == "__main__":

    root1 = TreeNode(1, None, TreeNode(2, TreeNode(2)))
    solution = Solution()
    assert solution.findMode(root1) == [2]

    root2 = TreeNode(0)
    solution = Solution()
    assert solution.findMode(root2) == [0]

    print("All tests passed.")
