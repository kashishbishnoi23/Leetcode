class LRUCache {

    static class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    };

    HashMap<Integer,Node> hashing; // stores the keys and values 
    int capacity;
    Node head;
    Node tail;
    int N;

    public LRUCache(int capacity) {
        this.capacity = capacity;  
        this.head = null;
        this.tail = null;  
        this.hashing = new HashMap<>();
        this.N = 0;
    }
    
    public int get(int key) {
        if (!hashing.containsKey(key)) return -1;
        int val = hashing.get(key).val;

        // change the priority of key => put it at last:
        changePriority(key);

        return val;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if (!hashing.isEmpty() && hashing.containsKey(key)){
            node = hashing.get(key);
            node.val = value;
            changePriority(key);
            return;
        }

        node = new Node(key, value);
        hashing.put(key, node);
        N++;

        if (head == null ){
            head = node;
            tail = node;
        } else {
            // put it at the end:
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }  
    


        if (N > capacity){
            Node toremove = head;
 
            if (head == tail){
                head = null;
                tail = null;
            } else {
                head = head.next;
                if (head != null) head.prev = null;
            }

            hashing.remove(toremove.key);

            
            N--;
        }
    }

    private void changePriority(int key){
        Node node = hashing.get(key);
        if (node == tail) return;
        if (node == head){
            head = node.next;
        }

        Node prev = null;
        Node next = null;

        if (node.prev != null) prev = node.prev;
        if (node.next != null) next = node.next;

        if (prev != null){
            prev.next = next;
        }

        if (next != null){
            next.prev = prev;
        }

        tail.next = node;
        node.prev = tail;
        tail = tail.next;

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */