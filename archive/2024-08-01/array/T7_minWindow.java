package org.rereview2024summer.array;

import java.util.HashMap;
import java.util.Map;

public class T7_minWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] string = s.toCharArray();
        char[] target = t.toCharArray();

        int distance = 0;
        for (char ch : target) {
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            distance++;
        }

        int right = 0, left = 0;
        int resL = 0, resR = 0;
        int minLen = Integer.MAX_VALUE;
        for ( ; right < string.length; right++) {
            char chR = string[right];
            if (map.containsKey(chR)) {
                if (map.get(chR) < 0)
                    distance--;
                map.put(chR, map.get(chR) + 1);
            }

            while (distance == 0) {
                char chL = string[left];
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    resL = left;
                    resR = right;
                }
                if (map.containsKey(chL)) {
                    if (map.get(chL) == 0)
                        distance++;
                    map.put(chL, map.get(chL)- 1);
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : new String(string, resL, resR - resL + 1);
    }
}
