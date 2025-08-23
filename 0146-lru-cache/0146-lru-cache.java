class LRUCache {
    
    // private static class Pair{
    //     int key;
    //     int value;
    //     int time;

    //     public Pair(int key, int value, int time){
    //         this.key = key;
    //         this.value = value;
    //         this.time = time;
    //     }
    // };

    // PriorityQueue <Pair>pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
    // int currTime = 0;

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    int capacity = 0;

    Node head;
    Node tail;

   

    Map<Integer, Node> hashing = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // create a head and tail , attach the head with tail:
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // if (!hashing.containsKey(key)) return -1;
        // currTime ++;
        // Pair p = hashing.get(key);
        // pq.remove(p);
        // p.time = currTime;
        // pq.offer(p);
        // return p.value;

        // if it exists in mapping -> return the value and move the node at the start:
        if (!hashing.containsKey(key)){
            return -1;
        }

        Node node = hashing.get(key);
        int val = node.value;
        node.prev.next = node.next;
        node.next.prev = node.prev;

        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;

        return val;


    }
    
    public void put(int key, int value) {
        // if (hashing.size() == capacity && !hashing.containsKey(key)){
        //     // remove the one which was used least recently:
        //     Pair p = pq.poll();
        //     hashing.remove(p.key);
        // }
        // currTime++;
        // if (hashing.containsKey(key)){
        //     Pair p = hashing.get(key);
        //     p.value = value;
        //     pq.remove(p);
        //     p.time = currTime;
        //     pq.offer(p);
        //     return;
        // }
        // Pair p = new Pair(key, value,currTime);

        // hashing.put(key, p);
        // pq.offer(p);
     

    if (capacity == hashing.size() && !hashing.containsKey(key)){
        // remove the LRU node
        Node toremove = this.tail.prev;
        toremove.prev.next = tail;
        tail.prev = toremove.prev;
        hashing.remove(toremove.key);
    }

    // jo bhi value put korge => vo recent value hogi -> recent values head k aage ayengi:
    Node node;

    // if map already contains this key -> simply update its value and put the node at front:
    if (hashing.containsKey(key)){
        node = hashing.get(key);
        node.value = value;
    // ab node ko utha ke front me daal do:
    Node prev = node.prev;
    Node next = node.next;

    prev.next = next;
    next.prev = prev;
    } else {
        node = new Node(key, value);
        hashing.put(key, node);
    }

 
    Node headNext = head.next;
    head.next = node;
    node.prev = head;
    node.next = headNext;
    headNext.prev = node;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */