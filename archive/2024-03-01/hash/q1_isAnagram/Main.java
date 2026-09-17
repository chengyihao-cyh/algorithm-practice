package org.learn2024spring.hash.q1_isAnagram;

public class Main {
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']--;
        }
        for (int j = 0; j < t.length(); j++) {
            frequency[t.charAt(j) - 'a']++;
        }
        // 用for-each遍历出 更简洁
        for (int f : frequency){
            if (f != 0) {
                return false;
            }
        }

        return true;
    }
}