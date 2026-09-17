package org.review2025springAgain.ch08_greedy;

import java.util.Arrays;

public class T1_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        // g胃口 s饼干
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int idx = g.length - 1;
        for (int i = s.length - 1; i >= 0; i--) {
            while (idx >= 0 && s[i] < g[idx]) {
                idx--;
            }
            if (idx < 0) {
                break;
            }
            else {
                idx--;
                count++;
            }
        }

        return count;
    }
}
