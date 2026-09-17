package org.review2024summer.greedy;

import java.util.Arrays;

public class T1_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int idx = s.length - 1;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = g.length - 1; i >= 0; i--) {
            if (idx >= 0 && s[idx] >= g[i]) {
                count++;
                idx--;
            }
        }
        return count;
    }
}
