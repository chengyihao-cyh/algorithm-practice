/**
 * Practice template for:
 * - LeetCode 455. Assign Cookies
 *   https://leetcode.cn/problems/assign-cookies/
 */
import java.util.Arrays;

public class T1_LC0455_FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
                Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gIdx = g.length - 1;
        for (int i = s.length - 1; i >= 0; i--) {
            while (gIdx >= 0 && s[i] < g[gIdx]) {
                gIdx--;
            }
            if (gIdx < 0) {
                break;
            } else {
                count++;
                gIdx--;
            }
        }
        return count;
    }
}
