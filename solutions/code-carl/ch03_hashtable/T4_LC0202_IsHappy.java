/**
 * Practice template for:
 * - LeetCode 202. Happy Number
 *   https://leetcode.cn/problems/happy-number/
 */
import java.util.HashSet;

public class T4_LC0202_IsHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> record = new HashSet<>();
        while (!record.contains(n) && n != 1) {
            record.add(n);
            n = nextInt(n);
        }
        return n == 1;
    }

    public int nextInt(int n) {
        int next = 0;
        while (n != 0) {
            int i = n % 10;
            next += i * i;
            n /= 10;
        }
        return next;
    }
}
