package org.rereview2024summer.hashtable;

import java.util.ArrayList;
import java.util.HashSet;

public class T3_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();

        for (int n1 : nums1)
            set.add(n1);
        for (int n2 : nums2)
            if (set.contains(n2))
                resSet.add(n2);

        int[] res = new int[resSet.size()];
        int i = 0;
        for (int n : resSet)
            res[i++] = n;
        return res;
    }
}
