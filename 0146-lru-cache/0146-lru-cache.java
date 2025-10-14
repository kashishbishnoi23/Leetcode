class LRUCache {

    static class Node{
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

    HashMap<Integer, Node> hashing = new HashMap<>();
    private int capacity;
    private int size;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        if (!hashing.containsKey(key)) return -1;

        changePriority(key);

        return hashing.get(key).value;
    }

    private void changePriority(int key){
        Node node = hashing.get(key);
        if (head == tail || tail.key == key) return;

        if (head.key == key) head = head.next;

        Node prev = node.prev;
        Node next = node.next;

        if (prev != null){
            prev.next = next;
        }

        if (next != null){
            next.prev = prev;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }
    
    public void put(int key, int value) {
        // if hashing already contains the key, simply update its value and change its priority:
        if (hashing.containsKey(key)){
            hashing.get(key).value = value;
            changePriority(key);
        } else {
            // create a new entry , add it to the end of the LL, and add to the hashmap:
            Node newnode = new Node(key, value);
            hashing.put(key, newnode);
            if (size >= capacity){
                // remove the first node:
                if (head == tail) tail = null;
                
                hashing.remove(head.key);
                head = head.next;
                if (head != null){
                    head.prev = null;
                }
                size--;
            }

            if (size == 0){
                head = newnode;
                tail = newnode;
                size++;
                return;
            }
            
            size++;
            if (tail != null) tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    } 
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */