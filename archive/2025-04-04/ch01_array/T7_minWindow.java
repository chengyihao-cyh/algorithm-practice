package org.review2025spring.ch01_array;

import java.util.HashMap;

public class T7_minWindow {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        int distance = t.length();

        // 初始化
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int resL = -1, resR = -1, minLen = Integer.MAX_VALUE;

        // i 右滑 扩大窗口
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) > 0) {
                    distance--;
                }
                map.put(ch, map.get(ch) - 1);
            }

            // j 右滑动 缩小窗口
            while (distance == 0) {
                if (i - j < minLen) {
                    resR = i;
                    resL = j;
                    minLen = i - j;
                }
                char delEle = s.charAt(j);
                if (map.containsKey(delEle)) {
                    if (map.get(delEle) == 0) {
                        distance++;
                    }
                    map.put(delEle, map.get(delEle) + 1);
                }
                j++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(resL, resR + 1);
    }
}
