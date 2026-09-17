/**
 * Practice template for:
 * - 3. Longest Substring Without Repeating Characters
 *   https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
import java.util.HashSet;
import java.util.Set;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/06 17:56
 * @comment
 */
public class T3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();

        int currLen = 0, maxLen = 0;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (set.contains(ch)) {
                while (j < i && array[j] != ch) {
                    set.remove(array[j]);
                    j++;
                }
                j++;
                currLen = i - j + 1;
            } else {
                currLen++;
                set.add(ch);
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}
