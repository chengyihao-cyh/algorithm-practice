package org.review2025autumn.ch08_greedy;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/4/5 17:32
 * @comment
 */
public class T10_lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else if (bill == 10) {
                count5--;
                count10++;
            } else if (bill == 20) {
                if (count10 > 0) {
                    count10--;
                    count5--;
                } else {
                    count5 -= 3;
                }
            }
            if (count5 < 0 || count10 < 0) {
                return false;
            }
        }
        return true;
    }
}
