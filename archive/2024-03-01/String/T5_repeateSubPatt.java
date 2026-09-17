package org.learn2024spring.String;

public class T5_repeateSubPatt {
    public boolean repeatedSubstringPattern(String s) {

        char[] string = s.toCharArray();
        int len = string.length;
        int[] next = new int[len];
        int i, j;

        j = 0;
        for (i = 1; i < len; i++) {
            while (j > 0 && string[i] != string[j])
                j = next[j - 1];
            if (string[i] == string[j])
                j++;
            next[i] = j;
        }

        int subLen = len - next[i - 1];
        return subLen != len && subLen != 0 && len % subLen == 0;   // idea简化
    }
}
