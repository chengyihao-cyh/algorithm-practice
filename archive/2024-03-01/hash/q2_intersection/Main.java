package org.learn2024spring.hash.q2_intersection;

import java.util.HashSet;

public class Main {
}

// 异位词
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 前处理
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }

        int[] resArr = new int[resSet.size()];
        int j = 0;
        for (int i : resSet) {
            resArr[j] = i;
            j++;
        }

        return resArr;
    }
}

// 赎金信
class Solution1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 先基于先剪枝
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // 对于字符，用数组做哈希表速度较快
        int[] records = new int[26];
        for (char ch : magazine.toCharArray()) {
            records[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            records[ch - 'a']--;
            if (records[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
