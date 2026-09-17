/**
 * Practice template for:
 * - LeetCode 349. Intersection of Two Arrays
 *   https://leetcode.cn/problems/intersection-of-two-arrays/
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T3_LC0349_Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int n1 : nums1) {
            set.add(n1);
        }
        for (int n2 : nums2) {
            if (set.contains(n2)) {
                set.remove(n2);
                res.add(n2);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
