import java.util.*;

class LFUCache {
    private class Node {
        int key, val, freq = 1;
        Node prev, next;
        Node(int k, int v) { 
            key = k; 
            val = v; 
        }
    }

    private class DoublyLinkedList {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        int size = 0;

        DoublyLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    private int capacity;
    private int minFreq = 0;
    private Map<Integer, Node> keyMap = new HashMap<>();
    private Map<Integer, DoublyLinkedList> freqMap = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        updateFreq(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            if (keyMap.size() == capacity) {
                DoublyLinkedList minList = freqMap.get(minFreq);
                Node evicted = minList.removeLast();
                keyMap.remove(evicted.key);
            }
            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);
            minFreq = 1;
            freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).add(newNode);
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).add(node);
    }
}