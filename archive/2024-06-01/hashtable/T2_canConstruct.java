package org.review2024summer.hashtable;

public class T2_canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] frequency = new int[26];
        if (magazine.length() < ransomNote.length())
            return false;
        for (int i = 0; i < ransomNote.length(); i++)
            frequency[ransomNote.charAt(i) - 'a'] --;
        for (int i = 0; i < magazine.length(); i++)
            frequency[magazine.charAt(i) - 'a'] ++;
        for (int f : frequency)
            if (f < 0)
                return false;
        return true;
    }
}
