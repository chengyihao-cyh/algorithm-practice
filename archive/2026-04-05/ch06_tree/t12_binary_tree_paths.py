"""LeetCode 257. Binary Tree Paths
https://leetcode.cn/problems/binary-tree-paths/
"""

from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        if not root:
            return []

        ans: List[str] = []
        path: List[str] = []

        def traversal(root: Optional[TreeNode]) -> None:
            if not root.left and not root.right:
                path.append(str(root.val))
                ans.append("->".join(path))
                path.pop()
                return

            path.append(str(root.val))

            if root.left:
                traversal(root.left)
            if root.right:
                traversal(root.right)
            path.pop()

        traversal(root)
        return ans


if __name__ == "__main__":
    solution = Solution()
    root = TreeNode(1, TreeNode(2, None, TreeNode(5)), TreeNode(3))

    print(solution.binaryTreePaths(root))

    assert sorted(solution.binaryTreePaths(root)) == ["1->2->5", "1->3"]
    assert solution.binaryTreePaths(None) == []
    print("All tests passed.")
