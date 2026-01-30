class MyCircularQueue {
    
    static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    int N = 0;
    Node top = null;
    Node rear = null;
    int capacity = 0;
    public MyCircularQueue(int k) {
        this.top = new Node(-1);
        this.rear = top;
        this.capacity = k;
    }
    
    public boolean enQueue(int value) {
        // naya element top k next pe jayega
        if (isFull()) return false;

        Node newnode = new Node(value);
        rear.next = newnode;
        rear = rear.next;
        N++;

        return true;

    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        top = top.next;
        N--;     
        return true;
        
    }
    
    public int Front() {
        if (isEmpty()) return -1;

        return top.next.value;
        
    }
    
    public int Rear() {
        if (isEmpty()) return -1;

        return rear.value;
    }
    
    public boolean isEmpty() {
        if (N == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if (N == capacity) return true;

        return false;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */