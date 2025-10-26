class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;
        int MOD = (int)(1e9 + 7);
        
        // create a prev smaller element array
        int[] pse = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++){
            int curr = arr[i];
            if (st.isEmpty()){
                pse[i] = -1;
            } else {
                while(!st.isEmpty() && arr[st.peek()] >= curr ){
                     // pop out the larger elements:
                     st.pop();
                }
                if (st.isEmpty()){
                    pse[i] = -1;
                } else {
                    pse[i] = st.peek();
                }
            }

            st.push(i);
        }


        // create a next smaller element array
        int[] nse = new int[n];
        Stack<Integer> st2 = new Stack<>();
        for (int j = n-1; j >= 0; j--){
            int curr = arr[j];
            if (st2.isEmpty()){
                nse[j] = n;
            } else {
                while(!st2.isEmpty() && arr[st2.peek()] > curr){
                    st2.pop();
                }

                if (st2.isEmpty()){
                    nse[j] = n;
                } else {
                    nse[j] = st2.peek();
                }
            }

            st2.push(j);
        }

        long ans = 0;

        for (int i = 0; i < n; i++){

            long left = i-pse[i];
            long right = nse[i] - i;

            long contri = (left*right) % MOD;
            System.out.println(contri);
            ans = (ans + (contri*arr[i]) % MOD) % MOD;

        }

        return (int)ans;
    }
}