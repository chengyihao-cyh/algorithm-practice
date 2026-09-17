package org.rereview2024summer.hashtable;

public class T2_isAnagram {
    public boolean isAnagram(String s, String t) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++)
            frequency[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            frequency[t.charAt(i) - 'a']--;
        for (int i : frequency)
            if (i != 0)
                return false;
        return true;
    }
}
