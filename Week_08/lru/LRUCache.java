package lru;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, DNode> lruCache;
    private int size;
    private int capacity;
    private DNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        lruCache = new HashMap<>(capacity);
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DNode node = lruCache.get(key);
        if (node == null) {
            return -1;
        }
        // 访问元素后添加到链表头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DNode node = lruCache.get(key);
        if (node == null) {
            DNode newNode = new DNode(key, value);
            lruCache.put(key, newNode);
            // 在链表头部添加结点
            addToHead(newNode);
            size ++;
            if (size > capacity) {
                // 超出容量，删除链表尾结点
                DNode tail = removeTail();
                lruCache.remove(tail.key);
                size --;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(DNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DNode node) {
        head.next.prev = node;
        node.next = head.next;

        head.next = node;
        node.prev = head;
    }

    private DNode removeTail() {
        DNode prev = tail.prev;
        removeNode(prev);
        return prev;
    }

    private void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;
        public DNode() {}
        public DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */