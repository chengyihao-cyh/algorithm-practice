package org.rereview2024summer.hashtable;

import java.util.HashSet;

public class T4_isHappy {
    public boolean isHappy(int n) {
        HashSet<Integer> records = new HashSet<>();
        while (!records.contains(n) && n != 1) {
            records.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}
