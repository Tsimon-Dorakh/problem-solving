package td.problemsolving.interviewbit.LRUCache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LRU Cache
 * https://www.interviewbit.com/problems/lru-cache/
 */
public class Solution {
    int timer = 0;
    int capacity;
    PriorityQueue<Item> heap = new PriorityQueue<>();
    Map<Integer, Item> map = new HashMap<>();

    public Solution(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Item item = map.get(key);
        refresh(item);

        return item.value;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Item item = map.get(key);
            refresh(item);
            item.value = value;
        } else {
            if (heap.size() == capacity) {
                Item item = heap.poll();
                map.remove(item.key);
            }

            Item item = new Item(timer++, key, value);
            map.put(key, item);
            heap.add(item);
        }
    }

    void refresh(Item item) {
        heap.remove(item);
        item.time = timer++;
        heap.add(item);
    }

    class Item implements Comparable<Item> {
        int time;
        int key;
        int value;

        public Item(int time, int key, int value) {
            this.time = time;
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(time, o.time);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Item item = (Item) o;

            if (time != item.time)
                return false;
            if (key != item.key)
                return false;
            return value == item.value;
        }

        @Override
        public int hashCode() {
            int result = time;
            result = 31 * result + key;
            result = 31 * result + value;
            return result;
        }

        @Override
        public String toString() {
            return "Item{" + "time=" + time + ", key=" + key + ", value=" + value + '}';
        }
    }
}
