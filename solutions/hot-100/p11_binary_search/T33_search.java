/**
 * Practice template for:
 * - 33. Search in Rotated Sorted Array
 *   https://leetcode.cn/problems/search-in-rotated-sorted-array/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/8 19:27
 * @comment
 */
public class T33_search {
    public int search0(int[] nums, int target) {
        int l = 0, r = nums.length - 2, mid = 0;
        int endVal = nums[nums.length - 1];

        while (l <= r) {
            mid = (l + r) / 2;
            if (target > endVal) {
                if (nums[mid] < endVal) {
                    r = mid - 1;
                } else {
                    if (nums[mid] < target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            } else {
                if (nums[mid] > endVal) {
                    l = mid + 1;
                } else {
                    if (nums[mid] < target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return l >= nums.length || nums[l] != target ? -1 : l;
    }

    public int search1(int[] nums, int target) {
        int l = 0, r = nums.length - 2, mid = 0;
        int endVal = nums[nums.length - 1];

        while (l <= r) {
            mid = (l + r) / 2;
            if (target > endVal) {
                if (nums[mid] < endVal || nums[mid] >= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] > endVal || nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return l >= nums.length || nums[l] != target ? -1 : l;
    }


    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int minIdx = findMin(nums);
        if (target > nums[nums.length - 1]) {
            return lowerBound(nums, target, 0, minIdx - 1);
        } else {
            return lowerBound(nums, target, minIdx, nums.length - 1);
        }
    }

    public int lowerBound(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l >= nums.length || nums[l] != target ? -1 : l;
    }

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[nums.length - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
