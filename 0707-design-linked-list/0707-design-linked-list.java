class MyLinkedList {

    static class Node{
        int val;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    int N;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.N = 0;
    }
    
    public Node getNode(int index) {
        
       int half = N/2;
       Node temp;
       int i;
       System.out.println("half = " + half);

       if (index >= half){
            i = N-1;
            temp = tail;
            // System.out.println("i = " + i);

            while(i > index){
                // System.out.println("temp = " + temp);
                temp = temp.prev;
                i--;
            }

       } else {
            i = 0;
            temp = head;
            while(i < index){
                // System.out.println("temp = " + temp);
                temp = temp.next;
                i++;
            }
       }

       return temp;

        
    }

    public int get(int index){
        if (index >= N) return -1;
        Node node = getNode(index);
        return node.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (head == null){
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        N++;

        // System.out.println("add at head : ");

        Node temp = head;

        // while(temp != null){
        //     // System.out.print(temp.val + " ");
        //     temp = temp.next; 
        // }

        // System.out.println();

        
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null){
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        N++;

        // System.out.println("add at tail : ");

        // Node temp = head;

        // while(temp != null){
        //     // System.out.print(temp.val + " ");
        //     temp = temp.next; 
        // }

        // System.out.println();


        
    }
    
    public void addAtIndex(int index, int val) {
        if (index > N) return;
        Node prev = index > 0 ? getNode(index-1) : null;
        Node node = new Node(val);
        if (prev == null){
            node.next = head;
            if (head != null) head.prev = node;
            head = node;
        } else {
            Node next = prev.next;
            prev.next = node;
            node.prev = prev;
            node.next = next;
            if (next != null) next.prev = node;
            if (next == null) tail = node;
        }

        // System.out.println("add at index  : " + index);

        // Node temp = head;

        // while(temp != null){
        //     // System.out.print(temp.val + " ");
        //     temp = temp.next; 
        // }
        N++;

        // System.out.println();


    }
    
    public void deleteAtIndex(int index) {
        if (head == null || index >= N) return;
        Node prev = index > 0 ? getNode(index-1) : null;

        if (prev == null){
            head = head.next;
            if (head != null) head.prev = null;
        } else {
            Node node = prev.next;
            Node next = node.next;
            prev.next = next;
            if (next != null) next.prev = prev;
            if (prev.next == null) tail = prev;

        }

        N--;

        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */