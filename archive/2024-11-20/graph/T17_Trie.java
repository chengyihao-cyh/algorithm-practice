package org.learn2024winter.graph;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/4 15:35
 * @comment
 */
public class T17_Trie {
    private Node dummyHead;
    public T17_Trie() {
        this.dummyHead = new Node(null);
    }

    public void insert(String word) {
        Node curr = dummyHead;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node(ch);
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node curr = dummyHead;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = dummyHead;
        char[] chars = prefix.toCharArray();
        for (char ch : chars) {
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return true;
    }



    class Node {
        Character value;
        Node[] children = new Node[26];
        boolean isEnd;

        public Node(Character value) {
            this.value = value;
            this.isEnd = false;
        }
    }
}
