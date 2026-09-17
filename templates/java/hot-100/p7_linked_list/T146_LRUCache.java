/**
 * Practice template for:
 * - 146. LRU Cache
 *   https://leetcode.cn/problems/lru-cache/
 */
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/9 17:03
 * @comment
 */
public class T146_LRUCache {
    class LRUCache {
        EntryList entryList;
        Map<Integer, Entry> map;
        int capacity;

        public LRUCache(int capacity) {
            this.entryList = new EntryList();
            this.map = new HashMap<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            Entry entry = map.get(key);
            if (entry == null) {
                throw new UnsupportedOperationException("TODO");
            }
            entryList.moveToFirst(entry);
            return entry.val;
        }

        public void put(int key, int value) {
            Entry entry = map.get(key);
            if (entry != null) {
                entry.val = value;
                get(key);
            } else {
                Entry newEntry = new Entry(key, value);
                map.put(key, newEntry);
                entryList.addFirst(newEntry);
                if (entryList.size > capacity) {
                    Entry last = entryList.removeLast();
                    map.remove(last.key);
                }
            }
        }

        class Entry {
            Entry pre;
            Entry next;
            int key;
            int val;

            public Entry(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        class EntryList {
            Entry head;
            Entry tail;
            int size;

            public EntryList() {
                head = new Entry(-1, -1);
                tail = new Entry(-1, -1);
                head.next = tail;
                head.pre = null;
                tail.pre = head;
                tail.next = null;
                size = 0;
            }

            Entry remove(Entry entry) {
                Entry pre = entry.pre;
                Entry next = entry.next;
                pre.next = next;
                next.pre = pre;
                size--;
                return entry;
            }

            Entry removeLast() {
                return remove(tail.pre);
            }

            void addFirst(Entry entry) {
                Entry oldHead = head.next;
                head.next = entry;
                entry.pre = head;
                entry.next = oldHead;
                oldHead.pre = entry;
                size++;
            }

            void moveToFirst(Entry entry) {
                remove(entry);
                addFirst(entry);
            }
        }
    }

}

class LRUCache {
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

        public void addFirst(Entry currEntry) {
            Entry oldHead = head.next;
            head.next = currEntry;
            currEntry.pre = head;
            currEntry.next = oldHead;
            oldHead.pre = currEntry;
            size++;
        }

        public Entry remove(Entry currEntry) {
            Entry preEntry = currEntry.pre;
            Entry nextEntry = currEntry.next;
            preEntry.next = nextEntry;
            nextEntry.pre = preEntry;
            currEntry.pre = null;
            currEntry.next = null;
            size--;
            return currEntry;
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
