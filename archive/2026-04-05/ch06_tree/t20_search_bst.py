"""LeetCode 700. Search in a Binary Search Tree
https://leetcode.cn/problems/search-in-a-binary-search-tree/
"""

from typing import Optional

from tree_node import TreeNode


class Solution:
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        while root:
            if root.val < val:
                root = root.right
            elif root.val > val:
                root = root.left
            else:
                return root

        return None


if __name__ == "__main__":
    solution = Solution()
    root = TreeNode(4, TreeNode(2, TreeNode(1), TreeNode(3)), TreeNode(7))

    node = solution.searchBST(root, 2)
    assert node is not None and node.val == 2
    assert node.left is not None and node.left.val == 1
    assert node.right is not None and node.right.val == 3

    assert solution.searchBST(root, 5) is None
    print("All tests passed.")
