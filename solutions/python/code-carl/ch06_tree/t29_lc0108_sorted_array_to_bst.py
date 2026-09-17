"""LeetCode 108. Convert Sorted Array to Binary Search Tree
https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
"""

from typing import List, Optional

from tree_node import TreeNode


class Solution:
    def sortedArrayToBST(self, nums: List[int]) -> Optional[TreeNode]:
        if not nums:
            return None

        def build(nums: List[int], start: int, end: int) -> Optional[TreeNode]:
            if start == end:
                return None
            elif start == end - 1:
                return TreeNode(val=nums[start])

            mid_idx = start + (end - start) // 2
            root = TreeNode(val=nums[mid_idx])
            root.left = build(nums, start, mid_idx)
            root.right = build(nums, mid_idx + 1, end)
            return root

        return build(nums, 0, len(nums))


if __name__ == "__main__":

    def inorder(root):
        if root is None:
            return []
        return inorder(root.left) + [root.val] + inorder(root.right)


    solution = Solution()
    nums1 = [-10, -3, 0, 5, 9]
    root1 = solution.sortedArrayToBST(nums1)
    assert root1 is not None
    assert inorder(root1) == nums1

    nums2 = [1, 3]
    root2 = solution.sortedArrayToBST(nums2)
    assert root2 is not None
    assert inorder(root2) == nums2
    print("All tests passed.")
