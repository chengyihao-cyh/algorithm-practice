package org.review2024summer.hashtable;

public class T2_isAnagram {
    public boolean isAnagram(String s, String t) {
        int[] frequency = new int[26];
        if (s.length() != t.length())
            return false;
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
            frequency[t.charAt(i) - 'a']--;
        }
        for (int f : frequency)
            if (f != 0)
                return false;
        return true;
    }
}
