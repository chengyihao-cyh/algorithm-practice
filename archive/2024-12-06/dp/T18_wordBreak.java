package org.review2024winter.dp;

import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 22:06
 * @comment
 */
public class T18_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int j = 0; j <= len; j++) {
            for (String word : wordDict) {
                if (j >= word.length() && dp[j - word.length()] && word.equals(s.substring(j - word.length(), j))) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
