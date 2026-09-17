/**
 * Practice template for:
 * - LeetCode 139. Word Break
 *   https://leetcode.cn/problems/word-break/
 */
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/22 22:06
 * @comment
 */
public class T18_LC0139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int j = 1; j <= len; j++) {
            for (String word : wordDict) {
                if (j >= word.length()) {
                    String patt = s.substring(j - word.length(), j);
                    if (word.equals(patt) && dp[j - word.length()]) {
                        dp[j] = true;
                        break;
                    }
                }
            }
        }
        return dp[len];
    }
}
