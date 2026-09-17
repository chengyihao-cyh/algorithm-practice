/**
 * Practice template for:
 * - LeetCode 1047. Remove All Adjacent Duplicates In String
 *   https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 */
public class T4_LC1047_RemoveDuplicates {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        int slow = 0, fast = 0;
        for (fast = 0;  fast < s.length(); fast++) {
            if (slow > 0 && chars[fast] == chars[slow - 1]) {
                slow--;
            } else {
                chars[slow] = chars[fast];
                slow++;
            }
        }
        return new String(chars, 0, slow);
    }
}
