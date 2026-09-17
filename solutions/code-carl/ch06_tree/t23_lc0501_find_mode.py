"""LeetCode 501. Find Mode in Binary Search Tree
https://leetcode.cn/problems/find-mode-in-binary-search-tree/
"""
import sys
from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        ans: List[int] = []
        pre_num = - sys.maxsize - 1
        max_cnt = 1
        curr_cnt = 1

        def traversal(root: Optional[TreeNode]) -> None:
            nonlocal pre_num, max_cnt, curr_cnt

            if not root:
                return

            traversal(root.left)

            if pre_num == - sys.maxsize - 1 or pre_num != root.val:
                curr_cnt = 1
            else:
                curr_cnt += 1
            pre_num = root.val

            if curr_cnt == max_cnt:
                ans.append(root.val)
            elif curr_cnt > max_cnt:
                max_cnt = curr_cnt
                ans.clear()
                ans.append(root.val)

            traversal(root.right)

        traversal(root)
        return ans


if __name__ == "__main__":
    solution = Solution()

    root1 = TreeNode(1, None, TreeNode(2, TreeNode(2)))
    assert solution.findMode(root1) == [2]

    root2 = TreeNode(0)
    assert solution.findMode(root2) == [0]

    print("All tests passed.")
