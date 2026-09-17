"""LeetCode 968. Binary Tree Cameras
https://leetcode.cn/problems/binary-tree-cameras/
"""

from __future__ import annotations

from typing import Optional

from tree_node import TreeNode


class Solution:

    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        pass


if __name__ == "__main__":
    def build_tree(nodes):
        if not nodes:
            return None
        values = list(nodes)
        root_val = values.pop(0)
        if root_val is None:
            return None
        root = TreeNode(root_val)
        queue = [root]
        while values and queue:
            node = queue.pop(0)
            if values:
                left_val = values.pop(0)
                if left_val is not None:
                    node.left = TreeNode(left_val)
                    queue.append(node.left)
            if values:
                right_val = values.pop(0)
                if right_val is not None:
                    node.right = TreeNode(right_val)
                    queue.append(node.right)
        return root


    solution = Solution()
    assert solution.minCameraCover(build_tree([0, 0, None, 0, 0])) == 1
    assert solution.minCameraCover(build_tree([0, 0, None, 0, None, 0, None, None, 0])) == 2
    print("All tests passed.")
