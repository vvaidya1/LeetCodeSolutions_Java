import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/lfu-cache/
 * O(n) time | O(1) space
 */
public class LfuCache {
    final int capacity;
    int size;
    int minFrequency;
    Map<Integer, Node> cache;
    Map<Integer, DoublyLinkedList> frequencyMap;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        updateNode(node);
        return node.value;
    }

    void updateNode(Node node) {
        DoublyLinkedList list = frequencyMap.get(node.frequency);
        list.remove(node);

        if (node.frequency == minFrequency && list.size() == 0)
            minFrequency++;

        node.frequency++;
        frequencyMap.putIfAbsent(node.frequency, new DoublyLinkedList());
        frequencyMap.get(node.frequency).insert(node);
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;

        if (cache.containsKey(key)) {
            Node curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
        } else {
            size++;
            if (size > capacity) {
                DoublyLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.remove(minFreqList.tail.prev);
                size--;
            }
            minFrequency = 1;
            Node newNode = new Node(key, value);
            frequencyMap.putIfAbsent(1, new DoublyLinkedList());
            frequencyMap.get(1).insert(newNode);
            cache.put(key, newNode);
        }
    }

    class Node {
        int key, value;
        Node prev, next;
        int frequency;

        public Node(int k, int v) {
            key = k;
            value = v;
            frequency = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        public DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);

            head.next = tail;
            tail.prev = head;
        }

        public void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }

        public void insert(Node node) {
            Node nextNode = head.next;
            node.next = nextNode;
            node.prev = head;
            head.next = node;
            nextNode.prev = node;
            size++;
        }

        public int size() {
            return size;
        }
    }
}



