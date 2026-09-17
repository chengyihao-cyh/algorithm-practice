package org.review2025autumn.ch11_graph;

import java.util.HashSet;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/2 20:19
 * @comment
 */
public class T9_ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        wordList.remove(beginWord);
        wordList.remove(endWord);

        HashSet<String> smallerVisited = new HashSet<>();
        HashSet<String> biggerVisited = new HashSet<>();
        smallerVisited.add(beginWord);
        biggerVisited.add(endWord);

        int step = 1;
        while (!smallerVisited.isEmpty() && !biggerVisited.isEmpty()) {
            step++;
            if (smallerVisited.size() > biggerVisited.size()) {
                HashSet<String> tmp = smallerVisited;
                smallerVisited = biggerVisited;
                biggerVisited = tmp;
            }

            HashSet<String> nextStepSet = new HashSet<>();
            for (String str : smallerVisited) {
                char[] currWord = str.toCharArray();
                for (int i = 0; i < currWord.length; i++) {
                    char originCh = currWord[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originCh)
                            continue;
                        currWord[i] = c;
                        String nextWord = String.valueOf(currWord);
                        if (biggerVisited.contains(nextWord))
                            return step;
                        if (wordSet.contains(nextWord)) {
                            wordSet.remove(nextWord);
                            nextStepSet.add(nextWord);
                        }
                    }
                    currWord[i] = originCh;
                }
                smallerVisited = nextStepSet;
            }
        }
        return 0;
    }
}
























