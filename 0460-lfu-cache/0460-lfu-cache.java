import java.util.*;

class LFUCache {

    static class Node{
        int key;
        int val;
        int freq;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
            this.next = null;
        }
    };

    static class LinkedList{
        Node head;
        Node tail;

        public LinkedList(){
            this.head = null;
            this.tail = null;
        }

        // add at Tail
        private void addAtTail(Node node){
            if (head == null){
                this.head = node;
                this.tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        // remove from Head
        private Node removeFromHead(){
            if (head == null) return null;
            Node node = head;
            head = head.next;
            if (head == null) tail = null;
            node.next = null;
            return node;
        }
    }

    HashMap<Integer, LinkedList> freqMap;
    HashMap<Integer, Node> hashing;
    int capacity;
    int N;
    int minFreq;

    public LFUCache(int capacity) {
        freqMap = new HashMap<>();
        hashing = new HashMap<>();
        this.capacity = capacity;
        this.N = 0;
        this.minFreq = 0;
    }

    // ---------------- FIXED ----------------
    private void changeFrequency(Node node){
        int currFreq = node.freq;
        LinkedList LL = freqMap.get(currFreq);

        Node temp = LL.head;
        Node prev = null;

        while (temp != null && temp != node){
            prev = temp;
            temp = temp.next;
        }

        Node next = temp.next;   // ✅ FIX

        if (prev == null){
            LL.head = next;
        } else {
            prev.next = next;
        }

        if (next == null){
            LL.tail = prev;
        }

        if (LL.head == null){
            freqMap.remove(currFreq);
            if (minFreq == currFreq) {
                minFreq++;     // ✅ FIX
            }
        }

        int newFreq = currFreq + 1;
        node.freq = newFreq;
        node.next = null;

        LinkedList LL2 = freqMap.getOrDefault(newFreq, new LinkedList());
        LL2.addAtTail(node);
        freqMap.put(newFreq, LL2);   // ✅ FIX
    }

    public int get(int key) {
        if (!hashing.containsKey(key)) return -1;

        Node node = hashing.get(key);
        changeFrequency(node);
        return node.val;
    }

    // ---------------- FIXED ----------------
    private void removeLeastFreq(){
        LinkedList LL = freqMap.get(minFreq);
        Node removed = LL.removeFromHead();

        if (removed != null){
            hashing.remove(removed.key);   // ✅ FIX
        }

        if (LL.head == null){
            freqMap.remove(minFreq);

            // ✅ FIX: recompute minFreq
            if (!freqMap.isEmpty()) {
                minFreq = Integer.MAX_VALUE;
                for (int f : freqMap.keySet()) {
                    minFreq = Math.min(minFreq, f);
                }
            }
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) return;   // ✅ FIX

        if (hashing.containsKey(key)){
            Node node = hashing.get(key);
            node.val = value;
            changeFrequency(node);
        } else {
            if (N == capacity){
                removeLeastFreq();
                N--;
            }

            Node node = new Node(key, value);
            hashing.put(key, node);

            LinkedList LL = freqMap.getOrDefault(1, new LinkedList());
            LL.addAtTail(node);
            freqMap.put(1, LL);     // ✅ FIX

            minFreq = 1;
            N++;
        }
    }
}
