class MyStack {

    // Queue<Integer> q1;
    // Queue<Integer> q2;

    Deque<Integer> dq;

    public MyStack() {
        this.dq = new LinkedList<Integer>(); 
    }

    
    public void push(int x) {
        dq.offerLast(x);
    }
    
    public int pop() {
        if (empty()) return -1;
        
        int value = dq.peekLast();
        dq.pollLast();

        return value;      
    }
    
    public int top() {
        if (empty()) return -1;

        return dq.peekLast();
        
    }
    
    public boolean empty() {

        if (dq.isEmpty()) return true;

        return false;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */