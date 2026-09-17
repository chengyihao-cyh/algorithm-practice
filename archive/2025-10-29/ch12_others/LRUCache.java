package org.review2025autumn.ch12_others;

import java.util.HashMap;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {
    public HashMap<Integer, Entry> key_table;
    int capacity;
    public EntryList entryList;

    public static class Entry {
        public Entry pre;
        public Entry next;
        public int key;
        public int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public LRUCache(int capacity) {
        this.key_table = new HashMap<>(capacity);
        this.capacity = capacity;
        this.entryList = new EntryList();
    }

    public int get(int key) {
        Entry entry = key_table.get(key);
        // 缓存未命中
        if (entry == null) return -1;
        // 缓存命中
        entryList.remove(entry);
        entryList.addFirst(entry);
        return entry.value;
    }

    public void put(int key, int value) {
        // key已存在
        Entry entry = key_table.get(key);
        if (entry != null) {
            entryList.remove(entry);
            entryList.addFirst(entry);
            entry.value = value;
            return;
        }

        // cache不存在
        Entry newEntry = new Entry(key, value);
        entryList.addFirst(newEntry);
        key_table.put(key, newEntry);
        if (entryList.size > capacity) {
            // 元素超出
            Entry oldTail = entryList.removeLast();
            key_table.remove(oldTail.key);
        }
    }


    public static class EntryList {
        Entry head;
        Entry tail;
        int size = 0;

        public EntryList() {
            this.head = new Entry(-1, -1);
            this.tail = new Entry(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public void addFirst(Entry entry) {
            Entry oldHead = head.next;
            head.next = entry;
            entry.pre = head;
            entry.next = oldHead;
            oldHead.pre = entry;
            size++;
        }

        public Entry remove(Entry entry) {
            Entry preEntry = entry.pre;
            Entry nextEntry = entry.next;
            preEntry.next = nextEntry;
            nextEntry.pre = preEntry;
            entry.pre = null;
            entry.next = null;
            size--;
            return entry;
        }

        public Entry removeLast() {
            if (size == 0) return null;
            return remove(tail.pre);
        }
    }


    public void print() {
        Entry curr = entryList.head;
        while (curr.next != entryList.tail) {
            System.out.print("{" + curr.next.key + ":" + curr.next.value + "}");
            curr = curr.next;
        }
        System.out.println();
    }
}

