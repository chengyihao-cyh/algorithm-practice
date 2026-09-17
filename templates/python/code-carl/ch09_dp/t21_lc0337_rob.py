"""LeetCode 337. House Robber III
https://leetcode.cn/problems/house-robber-iii/
"""

from __future__ import annotations

from typing import Optional

from template_py.ch06_tree.tree_node import TreeNode


class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
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
    assert solution.rob(build_tree([3, 2, 3, None, 3, None, 1])) == 7
    assert solution.rob(build_tree([3, 4, 5, 1, 3, None, 1])) == 9
    print("All tests passed.")
