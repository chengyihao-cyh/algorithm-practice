package org.review2025spring.ch03_hashtable;

import java.util.ArrayList;
import java.util.HashSet;

public class T3_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            if (set1.contains(n))
                resSet.add(n);
        }
        int[] res = new int[resSet.size()];
        int i = 0;
        for (int n : resSet) {
            res[i++] = n;
        }
        return res;
    }
}
