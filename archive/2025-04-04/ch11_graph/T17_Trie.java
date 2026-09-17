package org.review2025spring.ch11_graph;

import org.review2025spring.ch02_list.ListNode;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/4 15:35
 * @comment
 */
public class T17_Trie {
    public Node dummyHead;

    public T17_Trie() {
        this.dummyHead = new Node();
    }

    public void insert(String word) {
        int idx;
        Node curr = dummyHead;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            idx = chars[i] - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        int idx;
        Node curr = dummyHead;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            idx = chars[i] - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        int idx;
        Node curr = dummyHead;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            idx = chars[i] - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public class Node {
        public Node[] children;
        public boolean isEnd;

        public Node() {
            children = new Node[26];
            isEnd = false;
        }
    }

}
