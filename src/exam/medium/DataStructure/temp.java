package exam.medium.DataStructure;

import java.util.HashMap;
import java.util.Map;

public class temp {
}
class LRUCache2 {
    private Map<Integer, Node> map;
    private Node head, tail;
    private int capacity = 0;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node(-1, 1);
        this.tail = new Node(-1, 1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveNodeToTail(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            moveNodeToTail(node);
        } else {
            if (map.size() == capacity) removeNode(head.next);
            Node node = new Node(key, value);
            addNodeAtTail(node);
        }
    }

    private void removeNode(Node node) {
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addNodeAtTail(Node node) {
        map.put(node.key, node);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void moveNodeToTail(Node node) {
        removeNode(node);
        addNodeAtTail(node);
    }

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
}
