package org.review2025spring.ch03_hashtable;

import java.util.HashSet;

public class T4_isHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> record = new HashSet<>();
        int i = 0, sum = 0;
        while (true) {
            record.add(n);
            sum = 0;
            while (n != 0) {
                i = n % 10;
                sum += i * i;
                n /= 10;
            }
            n = sum;
            if (sum == 1)
                return true;
            if (record.contains(sum))
                return false;
        }
    }
}
