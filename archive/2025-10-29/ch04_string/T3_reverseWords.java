package org.review2025autumn.ch04_string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class T3_reverseWords {
    public String reverseWords(String s) {
        String[] split = s.trim().split(" ");
        List<String> collect = Arrays.stream(split)
                .filter(sp -> !sp.isEmpty()).
                collect(Collectors.toList());
        Collections.reverse(collect);
        return String.join(" ", collect);
    }
}

