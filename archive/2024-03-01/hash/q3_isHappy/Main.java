package org.learn2024spring.hash.q3_isHappy;

import java.util.HashSet;

public class Main {
}

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> records = new HashSet<>();
        while (n != 1) {
            records.add(n);
            n = getNext(n);
            if (records.contains(n)) {
                return false;
            }
        }
        return true;
    }
    public int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}