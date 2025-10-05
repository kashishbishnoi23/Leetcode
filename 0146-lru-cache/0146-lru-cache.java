class LRUCache {

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

    int capacity;
    int n;
    Node head;
    Node tail;

    HashMap<Integer, Node> hashing = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        n = 0;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        // System.out.println("get " + key);
        // for (int k : hashing.keySet()){
        //     System.out.println(k + " " + hashing.get(k).value);
        // }
        if (hashing.containsKey(key)){
            Node node = hashing.get(key);
            int value = node.value;
            changePriority(node);
            return value;
        }
        return -1;
    }

    private void changePriority(Node node){
        // put the node at tail:
        if (node == tail) return;

        Node prev = node.prev;
        Node next = node.next;

        if (node == head){
            head = head.next;
            head.prev = null;
        } else{
            if (next != null){
                next.prev = prev;
            }

            if (prev != null){
                prev.next = next;
            }
        }

        node.next = null;
        tail.next = node;
        node.prev = tail;
        tail = tail.next;


    }

    
    public void put(int key, int value) {
        // System.out.println("put " + key + " " + value);
        // for (int k : hashing.keySet()){
        //     System.out.println(k + " " + hashing.get(k).value);
        // }

        if (hashing.containsKey(key)){
            Node node = hashing.get(key);
            node.value = value;
            changePriority(node);
        } else {
            if (n >= capacity){
                // remove head:
                hashing.remove(head.key);
                head = head.next;
                if (head != null) head.prev = null;
                n--;  
            }

            Node node = new Node(key, value);
            hashing.put(key, node);
            // add new node at the end:
            if (n == 0){
                head = node;
                tail = node;
                n++;
                return;
            }
            n++;
            // node.next = null;
            tail.next = node;
            node.prev = tail;
            tail = tail.next;

         
        
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */