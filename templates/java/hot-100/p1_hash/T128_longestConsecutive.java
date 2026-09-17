/**
 * Practice template for:
 * - 128. Longest Consecutive Sequence
 *   https://leetcode.cn/problems/longest-consecutive-sequence/
 */
import java.util.HashSet;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/6 17:26
 * @comment
 */
public class T128_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int currLen = 0, maxLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                currLen = 0;
                while (set.contains(num++)) {
                    currLen++;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}
