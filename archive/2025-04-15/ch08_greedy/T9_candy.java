package org.review2025springAgain.ch08_greedy;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/5 17:03
 * @comment
 */
public class T9_candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        candies[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        int count = candies[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            count += candies[i];
        }
        return count;
    }
}
