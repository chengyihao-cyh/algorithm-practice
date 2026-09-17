package org.review2025autumn.ch02_list;

public class T9_Trie {

    static class Trie {

        Node dummyHead;

        public Trie() {
            this.dummyHead = new Node();
        }

        public void insert(String word) {
            Node curr = dummyHead;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.child[idx] == null) {
                    curr.child[idx] = new Node();
                }
                curr = curr.child[idx];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            Node curr = dummyHead;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                curr = curr.child[idx];
                if (curr == null) {
                    return false;
                }
            }
            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node curr = dummyHead;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                curr = curr.child[idx];
                if (curr == null) {
                    return false;
                }
            }
            return true;
        }

        static class Node {
            Boolean isEnd = false;
            Node[] child = new Node[26];
        }
    }

}

