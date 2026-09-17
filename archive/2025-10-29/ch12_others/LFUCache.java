package org.review2025autumn.ch12_others;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    public HashMap<Integer, EntryList> freq_table = new HashMap<>();
    public HashMap<Integer, Entry> key_table;
    public int size = 0;
    public int capacity;
    public int minFreq;

    public LFUCache(int capacity) {
        this.key_table = new HashMap<>(capacity);
        this.freq_table.put(1, new EntryList());
        this.capacity = capacity;
    }

    public int get(int key) {
        Entry entry = key_table.get(key);
        // 缓存未命中
        if (entry == null) return -1;
        // 缓存命中
        removeEntry(entry);
        addHeadByFreq(entry);
        return entry.value;
    }

    public void put(int key, int value) {
        Entry entry = key_table.get(key);
        // 缓存已存在
        if (entry != null) {
            entry.value = value;
            removeEntry(entry);
            addHeadByFreq(entry);
            return;
        }

        // 缓存不存在
        if (size == capacity) {
            removeMinFreqTail();
        }
        Entry newEntry = new Entry(key, value, 0);
        key_table.put(key, newEntry);
        addHeadByFreq(newEntry);
        minFreq = 1;
    }

    public void addHeadByFreq(Entry entry) {
        int freq = entry.freq + 1;
        entry.freq = freq;
        size++;
        EntryList list = freq_table.get(freq);
        if (list == null) {
            list = new EntryList();
            freq_table.put(freq, list);
        }
        list.addFirst(entry);
    }

    public void removeEntry(Entry entry) {
        EntryList list = freq_table.get(entry.freq);
        list.remove(entry);
        size--;
        if (list.isEmpty()) {
            freq_table.remove(entry.freq);
            if (minFreq == entry.freq) {
                minFreq++;
            }
        }
    }

    public Entry removeMinFreqTail() {
        EntryList list = freq_table.get(minFreq);
        Entry delEntry = list.removeLast();
        key_table.remove(delEntry.key);
        size--;
        if (list.isEmpty()) {
            freq_table.remove(minFreq);
            minFreq++;
        }
        return delEntry;
    }


    public class Entry {
        public Entry pre;
        public Entry next;
        public int key;
        public int value;
        public int freq;

        public Entry(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }

    public class EntryList {
        public Entry head;
        public Entry tail;
        public int size = 0;

        public EntryList() {
            this.head = new Entry(0, 0, 0);
            this.tail = new Entry(0, 0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public Entry remove(Entry entry) {
            Entry pre = entry.pre;
            Entry next = entry.next;
            pre.next = next;
            next.pre = pre;
            entry.pre = null;
            entry.next = null;
            size--;
            return entry;
        }

        public boolean addFirst(Entry entry) {
            Entry oldHead = head.next;
            head.next = entry;
            entry.pre = head;
            oldHead.pre = entry;
            entry.next = oldHead;
            size++;
            return true;
        }

        public Entry removeLast() {
            if (size == 0) return null;
            return remove(tail.pre);
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public void print() {
        System.out.println("======================");
        for (Map.Entry<Integer, EntryList> listEntry : freq_table.entrySet()) {
            Integer freq = listEntry.getKey();
            System.out.print(freq + ":");
            EntryList list = listEntry.getValue();
            Entry curr  = list.head;
            while (curr.next != list.tail) {
                Entry entry = curr.next;
                System.out.print("{" + entry.key + "," + entry.value + "}");
                curr = curr.next;
            }
            System.out.println();
        }
    }
}