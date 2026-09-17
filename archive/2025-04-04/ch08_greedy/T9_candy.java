package org.review2025spring.ch08_greedy;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/5 17:03
 * @comment
 */
public class T9_candy {
    public int candy(int[] ratings) {
        int[] candyCount = new int[ratings.length];
        candyCount[0] = 1;

        // 从左向右 判断i>i-1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyCount[i] = candyCount[i - 1] + 1;
            } else {
                candyCount[i] = 1;
            }
        }

        // 从右向左 判断i>i+1
        int count = candyCount[candyCount.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyCount[i] = Math.max(candyCount[i], candyCount[i + 1] + 1);
            }
            count += candyCount[i];
        }
        return count;
    }
}
