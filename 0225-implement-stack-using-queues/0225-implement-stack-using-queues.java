class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();    
    }
    
    public void push(int x) {
        q1.offer(x); 
    }
    
    public int pop() {
        if (empty()) return -1;
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }

        int value = q1.poll();
        q1 = q2;
        q2 = new LinkedList<>();

        return value;

    }
    
    public int top() {
        if (empty()) return -1;
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }

        int value = q1.peek();
        q2.offer(q1.poll());
        q1 = q2;
        q2 = new LinkedList<>();

        return value;

        
    }
    
    public boolean empty() {

        if (q1.isEmpty()) return true;

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