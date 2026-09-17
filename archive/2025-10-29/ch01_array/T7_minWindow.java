package org.review2025autumn.ch01_array;

import java.util.HashMap;
import java.util.Map;

public class T7_minWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] targets = t.toCharArray();
        for (char ch : targets) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int minL = 0, minR = 0, minLen = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        int distance = t.length();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    distance--;
                    while (distance == 0) {
                        if (minLen > i - j + 1) {
                            minLen = i - j + 1;
                            minL = j;
                            minR = i;
                        }
                        char preCh = chars[j];
                        if (map.containsKey(preCh)) {
                            map.put(preCh, map.get(preCh) + 1);
                            if (map.get(preCh) > 0) {
                                distance++;
                            }
                        }
                        j++;   // 别忘了一定要 j++ 很容易忘
                    }
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minR + 1);
    }
}
