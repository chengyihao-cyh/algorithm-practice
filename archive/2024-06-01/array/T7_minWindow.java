package org.review2024summer.array;

import java.util.HashMap;

public class T7_minWindow {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> check = new HashMap<>();
        int distance = 0;
        int left = 0, right = 0;
        int resL = -1, resR = -1;
        int minLen = Integer.MAX_VALUE;

        // 初始化
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            check.put(ch, check.getOrDefault(ch, 0) - 1);
            distance++;
        }

        // 滑动窗口
        // 先右移找可行解
        for (right = 0; right < s.length(); right++) {
            char chR = s.charAt(right);
            if (check.containsKey(chR)) {
                if (check.get(chR) < 0)
                    distance--;
                check.put(chR, check.getOrDefault(chR, 0) + 1);

                // 再左移找最优解
                while (distance == 0) {
                    int len = right - left + 1;
                    if (len < minLen) {
                        resL = left;
                        resR = right;
                        minLen = len;
                    }

                    char chL  = s.charAt(left);
                    if (check.containsKey(chL)) {
                        if (check.get(chL) == 0)
                            distance++;
                        check.put(chL, check.getOrDefault(chL, 0) - 1);
                    }
                    left++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(resL, resR + 1);
    }
}
