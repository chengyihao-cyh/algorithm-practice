package org.learn2024spring.array.q2_subStr;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        String res = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(res);
    }
}

// 用数组统计频率
// 问题？大数组浪费空间，ASIC码有128位，大小写跨度大。若想减少占用空间，则要开二维数组，分别对应大小写，但仍然会有很多字母未被使用，浪费空间。
// 解决？改用Map统计频率
class Solution1 {
    public static String minWindow(String s, String t) {
        int[] s_charFrequency = new int[26];
        int[] t_charFrequency = new int[26];
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        StringBuilder bestStr = new StringBuilder("");
        StringBuilder currStr = new StringBuilder("");
        char[] chars = s.toCharArray();
        for (int i = 0; i < t.length(); i++){
            t_charFrequency[Character.toLowerCase(t.charAt(i)) - 'a']++;
        }
        for (int right = 0; right < s.length(); right++){
            s_charFrequency[Character.toLowerCase(chars[right]) - 'a']++;
            currStr.append(chars[right]);
            while (isContain(s_charFrequency, t_charFrequency)){
                if (right - left + 1 < minLen){
                    minLen = right - left + 1;
                    bestStr = new StringBuilder(currStr);
                }
                s_charFrequency[Character.toLowerCase(chars[left]) - 'a']--;
                currStr.deleteCharAt(0);
                left++;
            }
        }
        return new String(bestStr);
    }

    public static boolean isContain(int[] s, int[] t){
        boolean flag = true;
        for(int i = 0; i < 26; i++) {
            if(t[i] > s[i]){
                flag = false;
                break;
            }
        }
        return flag;
    }

}


// 用 Map 统计频率
// 问题？为了操作HashMap的元素增减，设计了mapOperation函数，其实根本没必要。
// 解决？发现能用map.getOrDefault(ch, 0) + 1)代替该函数；
// 问题？显式设计了StringBuilder类对象currStr与bestStr，在长度增减时时间开销大。
// 解决？不必存储字符串，只需记录字符串起始坐标和结束坐标，返回时只需根据坐标在s上截取。
class Solution2 {
    static Integer ADD = 0;
    static Integer DEL = 1;
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        StringBuilder bestStr = new StringBuilder("");
        StringBuilder currStr = new StringBuilder("");

        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            mapOperation(t_map, ch, ADD);
        }

        for (int right = 0; right < s.length(); right++){
            char chRight = s.charAt(right);
            mapOperation(s_map, chRight, ADD);
            currStr.append(chRight);

            while (isContain(s_map, t_map)){
                char chLeft = s.charAt(left);
                int currLen = right - left + 1;
                if (currLen < minLen){
                    minLen = currLen;
                    bestStr = new StringBuilder(currStr);
                }
                mapOperation(s_map, chLeft, DEL);
                currStr.deleteCharAt(0);
                left++;
            }
        }
        return new String(bestStr);
    }

    public static boolean isContain(HashMap<Character, Integer> s_map, HashMap<Character, Integer> t_map) {
        boolean flag = true;
        for (Character t_key : t_map.keySet()) {
            if (!s_map.containsKey(t_key) || s_map.get(t_key) < t_map.get(t_key)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean mapOperation (HashMap < Character, Integer > map,char ch, int operation){
        if (operation == ADD) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        } else {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}


// 改进Operation，并改进字符串表示
// 问题？实际上没有必要用两个map，实在过于冗余。
// 解决？用一个check表示当前窗口含有元素和目标所需元素的差值。check值为{(A,-x1),(B,-x2),(C,0)...}表示当前窗口缺x1个A，多余X2个B，刚好有要求的C...当且仅当所有value>=0时，表明此时窗口包含target。
// 问题？发现在窗口滑动时，并不需要将左指针和右指针遇到的所有s的值都记录下，只需记录那些存在t中也出现的的字符即可。
// 例如：对s:"ADOBECODEBANC",t:"ABC"，在我们看来等价于"AXXBXCXXXBAXC"，我们只关心需要匹配的元素。
// 解决：在指针滑动时对遇到的元素，判定其是否是t中字符，如果不是直接忽略。
class Solution3 {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;

        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            t_map.put(ch, t_map.getOrDefault(ch, 0) + 1);
        }

        for (int right = 0; right < s.length(); right++){
            char chRight = s.charAt(right);
            s_map.put(chRight, s_map.getOrDefault(chRight, 0) + 1);

            while (isContain(s_map, t_map)){
                char chLeft = s.charAt(left);
                int currLen = right - left + 1;
                if (currLen < minLen){
                    minLen = currLen;
                    ansL = left;
                    ansR = right;
                }
                s_map.put(chLeft, s_map.get(chLeft) - 1);
                left++;
            }
        }
        String ansStr = ansL == -1 ? "" : s.substring(ansL, ansR + 1);  // subString左闭右开，ansR+1
        return ansStr;
    }

    public static boolean isContain(HashMap<Character, Integer> s_map, HashMap<Character, Integer> t_map) {
        boolean flag = true;
        for (Character t_key : t_map.keySet()) {
            if (!s_map.containsKey(t_key) || s_map.get(t_key) < t_map.get(t_key)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}

// 在上一版的基础上进行优化，将2个Map缩减为1，并且个仅考虑有效有效元素，忽视无效元素。
// 问题？滥用continue，导致形式上很糟糕。
// 解决？用逻辑if取代粗暴的continue，在我看来continue是一种断路，但可以通过if引导逻辑不进入某部分代码，而不是直接continue断路。
class Solution4 {
    HashMap<Character, Integer> check = new HashMap<>();
    public String minWindow(String s, String t) {

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;

        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            check.put(ch, check.getOrDefault(ch, 0) - 1);
        }

        for (int right = 0; right < s.length(); right++){
            char chRight = s.charAt(right);
            if (!check.containsKey(chRight)){
                continue;
            }
            check.put(chRight, check.get(chRight) + 1);
            while (isContain()){
                char chLeft = s.charAt(left);
                if (!check.containsKey(chLeft)){
                    left++;
                    continue;
                }
                if (check.get(chLeft) != 0){
                    left++;
                    check.put(chLeft, check.get(chLeft) - 1);
                    continue;
                }

                int currLen = right - left + 1;
                if (currLen < minLen){
                    minLen = currLen;
                    ansL = left;
                    ansR = right;
                }
                check.put(chLeft, check.get(chLeft) - 1);
                left++;
            }
        }
        String ansStr = ansL == -1 ? "" : s.substring(ansL, ansR + 1);  // subString左闭右开，ansR+1
        return ansStr;
    }

    public boolean isContain() {
        for (int n : check.values()) {
            if (n < 0){
                return false;
            }
        }
        return true;
    }

}

// 微调语法
// 问题？对照Leetcode题解发现还是较为啰嗦。尤其是isContain仅仅是查找map中有无value为负，竟然为此单独写了个函数，不是特别美观。
// 解决？通过引入distance表示窗口元素与target之间的元素差值。在右指针获取新元素时，仅当该元素是我们缺少的（即map.get(rightCh)<0），就减少distance，表示缩小了差距；
// 在左指针抛弃已有元素时，仅当该元素我们恰好不多不少（即map.get(leftCh)==0），再抛弃一个就不足时，就增加distance，表示差距增大了。
// 通过维护distance可直观反映元素的短缺情况，而不必一遍遍调用isContain判断所有value是否非负。
class Solution5 {
    HashMap<Character, Integer> check = new HashMap<>();
    public String minWindow(String s, String t) {

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;

        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            check.put(ch, check.getOrDefault(ch, 0) - 1);
        }

        for (int right = 0; right < s.length(); right++){
            char chRight = s.charAt(right);
            if (check.containsKey(chRight)){
                check.put(chRight, check.get(chRight) + 1);
                while (isContain()){
                    char chLeft = s.charAt(left);
                    if (check.containsKey(chLeft)){
                        int currLen = right - left + 1;
                        if (currLen < minLen){
                            minLen = currLen;
                            ansL = left;
                            ansR = right;
                        }
                        check.put(chLeft, check.get(chLeft) - 1);
                    }
                    left++;
                }
            }
        }
        String ansStr = ansL == -1 ? "" : s.substring(ansL, ansR + 1);  // subString左闭右开，ansR+1
        return ansStr;
    }
    public boolean isContain() {
        for (int n : check.values()) {
            if (n < 0){
                return false;
            }
        }
        return true;
    }
}

// 引入distance改造后
class Solution6 {
    public String minWindow(String s, String t) {

        Map<Character, Integer> check = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;
        int distance = t.length();

        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            check.put(ch, check.getOrDefault(ch, 0) - 1);
        }

        int left = 0;
        for (int right = 0; right < s.length(); right++){
            char chRight = s.charAt(right);
            if (check.containsKey(chRight)){
                if (check.get(chRight) < 0){
                    distance--;
                }
                check.put(chRight, check.get(chRight) + 1);
                while (distance == 0){
                    char chLeft = s.charAt(left);
                    if (check.containsKey(chLeft)){
                        int currLen = right - left + 1;
                        if (currLen < minLen){
                            minLen = currLen;
                            ansL = left;
                            ansR = right;
                        }
                        if (check.get(left) == 0){
                            distance++;
                        }
                        check.put(chLeft, check.get(chLeft) - 1);
                    }
                    left++;
                }
            }
        }
        String ansStr = ansL == -1 ? "" : s.substring(ansL, ansR + 1);  // subString左闭右开，ansR+1
        return ansStr;
    }
}

// 练手
class Solution7 {
    Map<Character, Integer> check = new HashMap<>();
    public String minWindow(String s, String t){
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int distance = t.length();
        int ansL = -1;
        int ansR = -1;

        for (int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            check.put(ch, check.getOrDefault(ch, 0) - 1);
        }

        for (int right = 0; right < s.length(); right++){
            char chRight = s.charAt(right);
            if (check.containsKey(chRight)){
                if (check.get(chRight) < 0){
                    distance--;
                }
                check.put(chRight, check.getOrDefault(chRight, 0 ) + 1);
                while (distance == 0){
                    char chLeft = s.charAt(left);
                    if (check.containsKey(chLeft)){
                        int currLen = right - left + 1;
                        if (currLen < minLen){
                            ansL = left;
                            ansR = right;
                            minLen = currLen;
                        }
                        if (check.get(chLeft) == 0){
                            distance++;
                        }
                        check.put(chLeft, check.getOrDefault(chLeft, 0 ) - 1);
                    }
                    left++;
                }
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }
}


























