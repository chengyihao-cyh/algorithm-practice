package org.review2024summer.hashtable;

import java.util.HashSet;

public class T3_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();
        for (int num1 : nums1)
            set1.add(num1);
        for (int num2 : nums2)
            if (set1.contains(num2))
                resSet.add(num2);

        int[] resArr = new int[resSet.size()];
        int idx = 0;
        for (int num : resSet)
            resArr[idx++] = num;

        return resArr;
    }
}
