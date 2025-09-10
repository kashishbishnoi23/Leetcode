class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // generate all the subarrays:
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++){
            int prod = 1;
            for (int j = i; j < n; j++){
                prod *= nums[j];
                if (prod < k){
                    count++;
                } else{
                    break;
                }
            }
        }

        return count;


    }
}