package org.review2024summer.hashtable;

import java.util.HashSet;

public class T4_isHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> records = new HashSet<>();

        while (n != 1 && !records.contains(n)) {
            records.add(n);
            n = getNext(n);
        }

        return n == 1;
    }

    public int getNext(int num) {
        int res = 0;
        while (num != 0) {
            int i = num % 10;
            res += i * i;
            num /= 10;
        }
        return res;
    }
}
