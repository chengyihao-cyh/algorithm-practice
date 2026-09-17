package org.review2025springAgain.ch09_dp;

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
        for (int j = 0; j <= s.length(); j++) {
            for (String word : wordDict) {
                if (j >= word.length() && dp[j - word.length()] && s.startsWith(word, j - word.length())) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
