package org.review2025springAgain.ch03_hashtable;

import java.util.HashSet;

public class T4_isHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n) && n != 1) {
            set.add(n);
            n = next(n);
        }
        return n == 1;
    }
    public int next(int n) {
        int sum = 0, tmp = 0;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}
