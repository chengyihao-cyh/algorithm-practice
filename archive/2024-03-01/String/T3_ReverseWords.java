package org.learn2024spring.String;

import java.util.ArrayList;

public class T3_ReverseWords {
    public String reverseWordsByLibrary(String s) {
        String[] words = s.split(" ");
        ArrayList<String> newWords = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (String word : words) {
           if (!word.equals("")) {
               newWords.add(0, word);
               newWords.add(0, " ");
           }
        }
        newWords.remove(0);
        newWords.forEach(str -> result.append(str));
        return new String(result);
    }

    public String reverseWords(String s) {

        return null;
    }

//    public StringBuilder removeAllSpace(String s) {
//        int fast = 0, slow = 0;
//        StringBuilder builder = new StringBuilder();
//        for (fast = 0; fast < s.length(); fast++) {
//            char ch = s.charAt(fast);
//            if (ch != ' ') {
//                builder.append(ch);
//            }
//        }
//
//        return null;
//    }


}





































