package completed;

import java.util.HashMap;

public class LRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private int cur = 0;
    private HashMap<Integer, Node> pool;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        pool = new HashMap<>();
        head = new Node(-1, -1);
    }

    private void addFirst(Node node) {
        if (head.next != null) {
            head.next.pre = node;
            node.next = head.next;
        }
        node.pre = head;
        head.next = node;
        if (tail == null)
            tail = node;
    }

    private void remove(Node node) {
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            if (tail.pre != head)
                tail = node.pre;
            else
                tail = null;
        }
        node.pre.next = node.next;
        node.next = null;
        node.pre = null;
    }

    private void removeAndAddFirst(Node node) {
        remove(node);
        addFirst(node);
    }


    public int get(int key) {
        Node node = pool.get(key);
        if (node == null)
            return -1;
        removeAndAddFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
//    1、检测是否存在，存在，直接更新
//    2、是否大于容量 否直接添加
//       是，移除队列尾部元素，移除pool中元素
//        将新元素插入头部
        if (pool.containsKey(key)) {
            pool.get(key).value = value;
            get(key);
        } else {
            Node n = new Node(key, value);
            if (cur == 0)
                tail = n;
            if (cur == capacity) {
                pool.remove(tail.key);
                remove(tail);
                cur--;
            }
            addFirst(n);
            pool.put(key, n);
            cur++;
        }
    }

    private static class Node {
        Node pre, next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            Node t = this;
            StringBuilder sb = new StringBuilder();
            while (t != null) {
                sb.append(t.key).append("->");
                t = t.next;
            }
            return sb.toString();
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */