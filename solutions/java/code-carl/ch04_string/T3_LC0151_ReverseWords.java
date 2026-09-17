/**
 * Practice template for:
 * - LeetCode 151. Reverse Words in a String
 *   https://leetcode.cn/problems/reverse-words-in-a-string/
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class T3_LC0151_ReverseWords {
    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        List<String> collect = Arrays.stream(split)
                .filter(sp -> !sp.isEmpty()).
                collect(Collectors.toList());
        Collections.reverse(collect);
        return String.join(" ", collect);
    }
}
