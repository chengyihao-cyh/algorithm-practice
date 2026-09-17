package org.review2025spring.ch09_dp;

import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 22:06
 * @comment
 */
public class T18_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (String word : wordDict) {
                if (j >= word.length() && dp[j - word.length()] && word.equals(s.substring(j - word.length(), j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public int multiplePack(int bagWeight, int[] weight, int[] value, int[] nums) {
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                for (int k = 1; k <= nums[i] && j - k * weight[i] >= 0; k++) {
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }
        return dp[bagWeight];
    }
}
