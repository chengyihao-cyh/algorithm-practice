package org.review2025springAgain.ch03_hashtable;

import java.util.HashSet;

public class T3_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> setUnion = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i))
                setUnion.add(i);
        }
        int[] res = new int[setUnion.size()];
        int idx = 0;
        for (Integer i : setUnion) {
            res[idx++] = i;
        }
        return res;
    }
}
