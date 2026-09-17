/**
 * Practice template for:
 * - LeetCode 108. Convert Sorted Array to Binary Search Tree
 *   https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 */
public class T29_LC0108_SortedArrayToBst {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        } else if (right - left <= 0) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
