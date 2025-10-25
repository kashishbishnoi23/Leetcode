class MinStack {
    

    // Linked list implementation karna pdega cuz O(1) time complexity chahiye

    static class Node{
        int value;
        int min;
        public Node(int value, int min){
            this.value = value;
            this.min = min;
        }
    }

    Stack<Node> st;


    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if (st.isEmpty()){
            st.push(new Node(val, val));
            return;
        }

        int min = Math.min(val, st.peek().min);

        st.push(new Node(val, min));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().value;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */