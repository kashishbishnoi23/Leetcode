class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashing = new HashMap<>();

        Stack<Integer> st = new Stack<>();

        for (int i = nums2.length-1; i >= 0; i--){
            if (st.isEmpty()){
                hashing.put(nums2[i], -1);
            } else {
                while(!st.isEmpty() && st.peek() < nums2[i]){
                    st.pop();
                }

                if (st.isEmpty()){
                    hashing.put(nums2[i], -1);
                } else {
                    hashing.put(nums2[i], st.peek());
                }

            
            }
                st.push(nums2[i]);
        
        }


            int[] ans = new int [nums1.length];

            for (int j = 0; j < nums1.length; j++){
                ans[j] = hashing.get(nums1[j]);
            }

            return ans;
        }
    
}