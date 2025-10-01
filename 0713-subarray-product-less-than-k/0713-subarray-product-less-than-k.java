class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;

        int n = nums.length;
        int count = 0;

        int left = 0;
        int product = 1;
        for (int right = 0; right < n; right++){
            product *= nums[right];

            while(left <= right && product >= k){
                product /= nums[left];
                left++;
            }

            count += Math.max(right-left+1, 0);

        }

        return count;
    }
}