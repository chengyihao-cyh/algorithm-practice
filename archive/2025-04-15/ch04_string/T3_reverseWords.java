package org.review2025springAgain.ch04_string;

public class T3_reverseWords {
    public String reverseWords(String s) {
        String[] split = s.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (String str : split) {
            builder.insert(0, str);
            builder.insert(0, " ");
        }
        builder.deleteCharAt(0);
        return builder.toString();
    }
}

