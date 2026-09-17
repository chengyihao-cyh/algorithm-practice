"""LeetCode 108. Convert Sorted Array to Binary Search Tree
https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
"""

from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        pass


if __name__ == "__main__":

    def inorder(root):
        if root is None:
            return []
        return inorder(root.left) + [root.val] + inorder(root.right)


    nums1 = [-10, -3, 0, 5, 9]
    solution = Solution()
    root1 = solution.sortedArrayToBST(nums1)
    assert root1 is not None
    assert inorder(root1) == nums1

    nums2 = [1, 3]
    solution = Solution()
    root2 = solution.sortedArrayToBST(nums2)
    assert root2 is not None
    assert inorder(root2) == nums2
    print("All tests passed.")
