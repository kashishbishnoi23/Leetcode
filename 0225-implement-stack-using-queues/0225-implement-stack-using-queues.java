class MyStack {

    // Queue<Integer> queue; 

    Deque<Integer> queue;
    public MyStack(){
        // queue = new LinkedList<>();
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        // queue.offer(x);
        queue.offerLast(x);
    }
    
    public int pop() {
        // go to the last node:
        // Queue<Integer> temp = new LinkedList<>();
         
        // int value = -1;
        // while(!queue.isEmpty()){
        //     value = queue.poll();
        //     if (queue.isEmpty()) break; 
        //     temp.offer(value);
        // }

        // queue = temp;
        // return value;

        return queue.pollLast();
        
    }
    
    public int top() {
        // int val = pop();
        // queue.offer(val);

        // return val;
        return queue.peekLast();
    }
    
    public boolean empty() {
        // return queue.isEmpty();

        return queue.isEmpty();


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