/**
 * Practice template for:
 * - 49. Group Anagrams
 *   https://leetcode.cn/problems/group-anagrams/
 */
import java.util.*;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/6 17:26
 * @comment
 */
public class T49_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }

}
