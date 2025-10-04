class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int [] ans = new int [n];

        // for (int i = 0; i < n; i++){
        //     int current = temperatures[i];

        //     for (int j = i+1; j < n; j++){
        //         if (temperatures[j] > current){
        //             ans[i] = j-i;
        //             break;
        //         }
        //     }
        // }

        Stack<Integer> st = new Stack<>();

        for (int i = n-1; i >= 0 ; i--){
            int curr = temperatures[i];

            while(!st.isEmpty() && temperatures[st.peek()] <= curr){
                st.pop();
            }
            int next = st.isEmpty() ? 0 : st.peek();

            if (st.isEmpty()){
                ans[i] = 0;
            } else {
                ans[i] = next-i;
            }

            st.push(i);
        }

        return ans;
    }
}