class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
         Deque<Integer> dq = new LinkedList<>();
        int[] ans = new int [n-k+1];
        int index = 0;

        int left = 0;
        int right = 0;

        while(right < n){
            int curr = nums[right];
            while(!dq.isEmpty() && curr > nums[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(right);

            if (right-left + 1 == k){
                ans[index++] = nums[dq.peekFirst()];
                while(!dq.isEmpty() && dq.peekFirst() <= left){
                    dq.pollFirst();
                }
                left++; 
            }
            right++;

        }

        return ans;
    }
}