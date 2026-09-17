package org.learn2024winter.dp;

import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 22:06
 * @comment
 */
public class T18_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int bagSize = s.length();
        int[] dp = new int[bagSize + 1];
        for (int j = 0; j <= bagSize; j++) {
            for (String word : wordDict) {
                int len = word.length();
                if (j >= len) {
                    String pattern = s.substring(j - len, j);
                    if (word.equals(pattern)) {
                        dp[j] = Math.max(dp[j], dp[j - len] + len);
                    }
                }
            }
        }

        return dp[bagSize] == bagSize;
    }
}
