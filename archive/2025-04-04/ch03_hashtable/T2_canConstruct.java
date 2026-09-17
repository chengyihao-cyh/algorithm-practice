package org.review2025spring.ch03_hashtable;

public class T2_canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i)- 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            freq[ransomNote.charAt(i) - 'a']--;
        }
        for (int i : freq) {
            if (i < 0)
                return false;
        }
        return true;
    }
}
