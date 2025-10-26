class Solution {

    private long max(int[] nums){
        int n = nums.length;
        long ans = 0;

        // max rahega -> jab tak sath wale chhote hain -> find the larger element

        // prev max element:
        int[] pme = new int [n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++){
            int curr = nums[i];
            if (st.isEmpty()){
                pme[i] = -1;
            } else {
                // pop out the min element:
                while(!st.isEmpty() && nums[st.peek()] <= curr){
                    st.pop();
                }

                if (st.isEmpty()){
                    pme[i] = -1;
                } else {
                    pme[i] = st.peek();
                }
            }
            st.push(i);
        }

        st = new Stack<>();
        
        // next max element:

        int[] nme = new int[n];
        for (int j = n-1; j >= 0; j--){
            int curr = nums[j];
            if (st.isEmpty()){
                nme[j] = n;
            } else{
                while(!st.isEmpty() && nums[st.peek()] < curr){
                    st.pop();
                }

                if (st.isEmpty()){
                    nme[j] = n;
                } else {
                    nme[j] = st.peek();
                }
            }
            st.push(j);
        }

 

        for (int i = 0; i < n; i++){
            long left = i-pme[i];
            long right = nme[i] - i;

            ans += (left*right)*nums[i];


        }

        return ans;

    }

    private long min(int[] nums){

// agar muje subarray ka min chahiye -> vo element kab tak min rahega -> agar side wale elements usse bade honge -> find the smaller element index -> waha ruko
        int n = nums.length;
        long ans = 0;

        // prev min element:
        int[] pme = new int [n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++){
            int curr = nums[i];
            if (st.isEmpty()){
                pme[i] = -1;
            } else {
                // pop out the min element:
                while(!st.isEmpty() && nums[st.peek()] >= curr){
                    st.pop();
                }

                if (st.isEmpty()){
                    pme[i] = -1;
                } else {
                    pme[i] = st.peek();
                }
            }
            st.push(i);
        }

        st = new Stack<>();
        
        // next min element:

        int[] nme = new int[n];
        for (int j = n-1; j >= 0; j--){
            int curr = nums[j];
            if (st.isEmpty()){
                nme[j] = n;
            } else{
                while(!st.isEmpty() && nums[st.peek()] > curr){
                    st.pop();
                }

                if (st.isEmpty()){
                    nme[j] = n;
                } else {
                    nme[j] = st.peek();
                }
            }
            st.push(j);
        }



        for (int i = 0; i < n; i++){
            long left = i - pme[i];
            long right = nme[i] - i;

            ans += (left*right)*nums[i];


        }

        return ans;

    }
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        // sabhi subarrays ke max-min add krna hai

        // sabhi subarrays ka min ka sum nikalo

        // sabhi subarrays ke max ka sum nikalo

        // max sum - min sum krlo

        long maxSum = max(nums);
        System.out.println(maxSum);
        long minSum = min(nums);
        System.out.println(minSum);


        return maxSum - minSum;


    }
}