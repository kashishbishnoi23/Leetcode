class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxi = nums[0];
        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < n; i++){
           prefix *= nums[i];
           suffix *= nums[n-i-1];

           maxi = Math.max(maxi, Math.max(prefix, suffix));
           if (prefix == 0) prefix = 1;
           if (suffix == 0) suffix = 1;
        }
        return maxi;
    }
}