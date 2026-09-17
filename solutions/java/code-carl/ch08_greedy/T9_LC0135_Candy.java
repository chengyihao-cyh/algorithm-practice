/**
 * Practice template for:
 * - LeetCode 135. Candy
 *   https://leetcode.cn/problems/candy/
 */
/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/5 17:03
 * @comment
 */
public class T9_LC0135_Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        candies[0] = 1;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        int count = candies[candies.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            count += candies[i];
        }
        return count;
    }
}
