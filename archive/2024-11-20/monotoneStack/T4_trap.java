package org.learn2024winter.monotoneStack;

import java.util.ArrayDeque;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/11/28 23:36
 * @comment
 */
public class T4_trap {
    public int trap1(int[] height) {
        int sum = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);  // 要先存入 0
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int minIdx = stack.pop();
                    if (!stack.isEmpty()) {
                        int leftIdx = stack.peek(), rightIdx = i;
                        int h = Math.min(height[leftIdx], height[rightIdx]) - height[minIdx];
                        int w = rightIdx - leftIdx - 1;
                        sum += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int sum = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>(); // 不用先存入0
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                Integer minIdx = stack.pop();
                if (!stack.isEmpty()) {
                    // i为rightIdx stack.peek()为leftIdx
                    int h = Math.min(height[i], height[stack.peek()]) - height[minIdx];
                    int w = i - stack.peek() - 1;
                    sum += h * w;
                }
            }
            stack.push(i);
        }
        return sum;
    }

    public int trap3(int[] height) {
        int sum = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = height[stack.pop()];
                if (!stack.isEmpty()) {
                    int h = Math.min(height[i], height[stack.peek()]) - mid;
                    int w = i - stack.peek() - 1;
                    sum += h * w;
                }
            }
            stack.push(i);
        }
        return sum;
    }

    public int trap4(int[] height) {
        int length = height.length;
        if (length <= 2) return 0;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        // 记录每个柱子左边柱子最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i < length; i++) maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);

        // 记录每个柱子右边柱子最大高度
        maxRight[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) maxRight[i] = Math.max(height[i], maxRight[i + 1]);

        // 求和
        int sum = 0;
        for (int i = 1; i <= length - 1; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) sum += count;
        }
        return sum;
    }

    public int trap5(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        // 从两边向中间寻找最值
        int maxLeft = height[0], maxRight = height[height.length - 1];
        int l = 1, r = height.length - 2;
        int res = 0;
        while (l <= r) {
            // 不确定上一轮是左边移动还是右边移动，所以两边都需更新最值
            maxLeft = Math.max(maxLeft, height[l]);
            maxRight = Math.max(maxRight, height[r]);
            // 最值较小的一边所能装的水量已定，所以移动较小的一边。
            if (maxLeft < maxRight) {
                res += maxLeft - height[l++];
            } else {
                res += maxRight - height[r--];
            }
        }
        return res;
    }
}




















