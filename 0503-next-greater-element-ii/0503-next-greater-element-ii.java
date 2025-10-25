class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        for (int j = n-1; j >= 0; j--){

            while(!st.isEmpty() && st.peek() <= nums[j]){
                 st.pop();
            }
             st.push(nums[j]);
        }

        int[] ans = new int[n];

        for (int j = n-1; j >= 0; j--){
            if (st.isEmpty()){
                ans[j] = -1;
            } else {
                while(!st.isEmpty() && st.peek() <= nums[j]){
                 st.pop();
            }
            if (st.isEmpty()){
                ans[j] = -1;
            } else {
                ans[j] = st.peek();
            }
            
        }

            st.push(nums[j]);
        }

        return ans;
    }
}