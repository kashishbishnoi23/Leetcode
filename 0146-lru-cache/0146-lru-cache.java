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

    // keep a hashmap to have a track of if this key is present or not:
    HashMap<Integer, Node> hashing;
    Node head;
    Node last;

    int capacity;
    int N;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.N = 0;
        this.hashing = new HashMap<>();
        this.head = null;
        this.last = null;
    }

    private void changePriority(int key){
        // isko uthaake last pe lagado:
        Node node = hashing.get(key);

        if (last == node) return;
        if (node == head){
            head = head.next;
            if (head != null){
                head.prev = null;
            }
        }
   
        Node prev = node.prev;
        Node next = node.next;

        if (prev != null){
            prev.next = next;
        }

        if (next != null){
            next.prev = prev;
        }

        last.next = node;
        node.prev = last;
        last = node;

    }
    
    public int get(int key) {
        if (hashing.containsKey(key)){
            changePriority(key);
            return hashing.get(key).value;
        }
        return -1;

        // agar present nahi hai to create a new node and insert it at the end:     
    }
    
    public void put(int key, int value) {

        if (hashing.containsKey(key)){
            hashing.get(key).value = value;
            changePriority(key);
            return;
        }

        if (this.N == this.capacity){
            // remove the first element:
            hashing.remove(head.key);
            head = head.next;
            if (head != null){
                head.prev = null;
            }

            this.N--;
        }

        // create a new node:
        Node newnode = new Node(key, value);
        hashing.put(key, newnode);
        this.N++;

        if (head == null){
            head = newnode;
            last = newnode;
            return;
        }


        
        last.next = newnode;
        newnode.prev = last;
        last = newnode;

        

        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */