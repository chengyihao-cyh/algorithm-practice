"""LeetCode 257. Binary Tree Paths
https://leetcode.cn/problems/binary-tree-paths/
"""

from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        pass


if __name__ == "__main__":
    root = TreeNode(1, TreeNode(2, None, TreeNode(5)), TreeNode(3))
    solution = Solution()
    assert sorted(solution.binaryTreePaths(root)) == ["1->2->5", "1->3"]
    solution = Solution()
    assert solution.binaryTreePaths(None) == []
    print("All tests passed.")
