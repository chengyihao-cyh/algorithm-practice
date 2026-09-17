/**
 * Practice template for:
 * - 438. Find All Anagrams in a String
 *   https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 */
import java.util.*;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/06 17:56
 * @comment
 */
public class T438_findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        char[] array = s.toCharArray();
        char[] patt = p.toCharArray();
        int[] freq = new int[26];
        for (char ch : patt) {
            freq[ch - 'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        int l = 0;
        for (int r = 0; r < array.length; r++) {
            int c = array[r] - 'a';
            freq[c]--;  // 右侧元素入窗口
            while (freq[c] < 0) {
                freq[array[l] - 'a']++;  // 左侧元素出窗口
                l++;
            }
            if (r- l + 1 == p.length()) {
                ans.add(l);
            }
        }
        return ans;
    }
}
