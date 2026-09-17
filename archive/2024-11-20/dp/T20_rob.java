package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 18:27
 * @comment
 */
public class T20_rob {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);
        // [start, end)
        return Math.max(
                robAction(nums, 0, len - 1),
                robAction(nums, 1, len));
    }

    public int robAction(int[] nums, int start, int end) {
        if (start + 1 == end) return nums[start];
        int pre = nums[start];
        int curr = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int tmp = Math.max(curr, pre + nums[i]);
            pre = curr;
            curr = tmp;
        }
        return curr;
    }
}
