class StockSpanner {

    Stack<int[]> st;
    int index ;
    public StockSpanner() {
        st = new Stack<>();
        index = 0;
    }
    
    public int next(int price) {
        // if (st.isEmpty()){
        //     st.push(price);
        //     return 1;
        // }

        // Stack<Integer> temp = new Stack<>();

        // while(!st.isEmpty() && st.peek() <= price){
        //     temp.push(st.pop());
        // }

        // int ans = temp.size() + 1;

        // while(!temp.isEmpty()){
        //     st.push(temp.pop());
        // }

        // st.push(price);


        // return ans;



        while(!st.isEmpty() && st.peek()[0] <= price){
            st.pop();
        }
         int ans = 0;
        if (st.isEmpty()){
            st.push(new int[]{price, index});
            ans = index+1;
            index++;
            return ans;
        }

        ans = index - st.peek()[1];
        st.push(new int[] {price, index});
        index++;

        return ans;




    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */