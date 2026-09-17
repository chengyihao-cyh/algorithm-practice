"""LeetCode 106. Construct Binary Tree from Inorder and Postorder Traversal
https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
"""

from typing import List, Optional, Dict

from tree_node import TreeNode


#             |idx|
# inorder = [9,3,15,20,7]
#               |       |idx
# postorder = [9,15,7,20,3]
class Solution:
    def buildTree(
            self, inorder: List[int], postorder: List[int]
    ) -> Optional[TreeNode]:
        dic: Dict[int, int] = {}
        for idx, num in enumerate(inorder):
            dic[num] = idx

        def build(
                inorder: List[int], in_start: int, in_end: int,
                postorder: List[int], post_start: int, post_end: int
        ) -> Optional[TreeNode]:
            if in_end == in_start:
                return None
            elif in_end == in_start + 1:
                return TreeNode(val=postorder[post_end - 1])

            root_val = postorder[post_end - 1]
            root_idx = dic[root_val]
            root = TreeNode(val=root_val)

            root.left = build(
                inorder, in_start, root_idx,
                postorder, post_start, post_start + root_idx - in_start
            )
            root.right = build(
                inorder, root_idx + 1, in_end,
                postorder, post_start + root_idx - in_start, post_end - 1
            )
            return root

        return build(inorder, 0, len(inorder), postorder, 0, len(postorder))


if __name__ == "__main__":
    solution = Solution()
    root1 = solution.buildTree([9, 3, 15, 20, 7], [9, 15, 7, 20, 3])
    assert root1.val == 3
    assert root1.left.val == 9
    assert root1.right.val == 20
    assert root1.right.left.val == 15
    assert root1.right.right.val == 7

    root2 = solution.buildTree([-1], [-1])
    assert root2 is not None and root2.val == -1
    print("All tests passed.")
