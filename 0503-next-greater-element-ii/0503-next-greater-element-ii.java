class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        for (int i = n-2; i >= 0; i--){
            st.push(nums[i]);
        } 

        int[] ans = new int[n];

        // while(!st.isEmpty())

        for (int i = n-1; i >= 0; i--){
            // check if the stack has a greater element than the current element:
            int curr = nums[i];
            while(!st.isEmpty() && st.peek() <= curr){
                st.pop();
            }

            if (st.isEmpty()){
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(curr);
        }

        return ans;

    }
}