package org.learn2024winter.dp;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/23 18:00
 * @comment
 */
public class T19_rob {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        // dp[i]: 对下标 [0-i] 房间最多能获取的价值
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1)  {
            return nums[0];
        }

        int pre = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int tmp = Math.max(curr, pre + nums[i]);
            pre = curr;
            curr = tmp;
        }
        return curr;
    }
}

