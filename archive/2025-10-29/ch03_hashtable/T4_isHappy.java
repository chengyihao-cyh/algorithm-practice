package org.review2025autumn.ch03_hashtable;

import java.util.HashSet;

public class T4_isHappy {
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
