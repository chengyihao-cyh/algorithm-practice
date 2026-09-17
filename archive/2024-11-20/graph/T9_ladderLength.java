package org.learn2024winter.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
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
        if (!wordSet.contains(endWord)) return 0;
        // wordSet.remove(beginWord);

        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                String currWord = queue.poll();
                char[] currChars = currWord.toCharArray();
                for (int i = 0; i < currChars.length; i++) {
                    char originCh = currChars[i];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == originCh) continue;
                        currChars[i] = k;
                        String nextWord = String.valueOf(currChars);
                        if (nextWord.equals(endWord)) {
                            return step;
                        }
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                    currChars[i] = originCh;
                }
            }
        }
        return 0;
    }

    public boolean changeWordEveryLetter(String currWord, String endWord, LinkedList<String> queue, HashSet<String> visited, HashSet<String> wordSet) {
        char[] currChars = currWord.toCharArray();
        for (int i = 0; i < currChars.length; i++) {
            char originCh = currChars[i];
            for (char k = 'a'; k <= 'z'; k++) {
                if (k == originCh) continue;
                currChars[i] = k; // 替换
                String nextWord = String.valueOf(currChars);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord); // 访问后再入队
                        queue.add(nextWord);
                    }
                }
            }
            currChars[i] = originCh;
        }

        return false;
    }

    public int ladderLength_2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        HashSet<String> visited = new HashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        visited.add(beginWord);
        queue.offer(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                char[] currWord = queue.poll().toCharArray();
                for (int i = 0; i < currWord.length; i++) {
                    char originChar = currWord[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originChar)
                            continue;
                        currWord[i] = ch;
                        String nextWord = String.valueOf(currWord);
                        if (nextWord.equals(endWord))
                            return step;
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                    currWord[i] = originChar;
                }
            }
        }
        return 0;
    }

    public int ladderLength_3(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            step++;   // 层数 + 1
            int size = queue.size();
            while (size-- > 0) {
                // 依次遍历当前队列中的单词
                char[] currWord = queue.poll().toCharArray();
                // 尝试对 currWord 修改每一个字符，看看是不是能与 endWord 匹配
                for (int i = 0; i < currWord.length; i++) {
                    // 先保存，然后恢复
                    char originChar = currWord[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originChar)
                            continue;
                        currWord[i] = ch;
                        String nextWord = String.valueOf(currWord);
                        // 能够修改 1 个字符与 endWord 相同 返回 step
                        if (nextWord.equals(endWord))
                            return step;
                        // nextWord在词表中且未被访问过
                        if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                            // 注意：添加到队列以后，必须马上标记为已经访问
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                    // 恢复
                    currWord[i] = originChar;
                }
            }
        }
        return 0;
    }

    public int ladderLength_4(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        wordSet.remove(beginWord);
        wordSet.remove(endWord);

        HashSet<String> smallerVisited = new HashSet<>();
        HashSet<String> biggerVisited = new HashSet<>();
        smallerVisited.add(beginWord);
        biggerVisited.add(endWord);

        int step = 1;
        while (!smallerVisited.isEmpty() && !biggerVisited.isEmpty()) {
            step++;
            // 始终从较小的一侧扩展
            if (smallerVisited.size() > biggerVisited.size()) {
                HashSet<String> temp = smallerVisited;
                smallerVisited = biggerVisited;
                biggerVisited = temp;
            }

            HashSet<String> nextLevelVisited = new HashSet<>();
            for (String str : smallerVisited) {
                char[] currWord = str.toCharArray();
                for (int i = 0; i < currWord.length; i++) {
                    char originCh = currWord[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == originCh)
                            continue;
                        currWord[i] = ch;
                        String nextWord = new String(currWord);
                        if (biggerVisited.contains(nextWord)) {
                            return step; // 两边相遇
                        }
                        if (wordSet.contains(nextWord)) {
                            nextLevelVisited.add(nextWord);
                            wordSet.remove(nextWord); // 防止重复访问
                        }
                    }
                    currWord[i] = originCh; // 恢复原始字符
                }
            }

            smallerVisited = nextLevelVisited;
        }
        return 0;
    }



}
























