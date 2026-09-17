package org.review2025autumn.ch03_hashtable;

public class T2_isAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] check = new int[26];
        for (int i = 0; i < s.length(); i++) {
            check[s.charAt(i) - 'a']++;
            check[t.charAt(i) - 'a']--;
        }
        for (int i : check) {
            if (i != 0) return false;
        }

        return true;
    }
}
