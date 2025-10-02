class Solution {
    private boolean helper(int[] nums, int target, int index, int [][] dp){

        if (index == -1) return false;
        if (dp[index][target] == 1){
            return true;
        }

        if (dp[index][target] == 2) return false;
        
        if (nums[index] == target) return true;

        if (nums[index] > target){
            boolean ans = helper(nums, target, index-1, dp);
            if (ans == true){
                dp[index][target] = 1;
            } else {
                dp[index][target] = 2;
            }
            return ans;
        }

        boolean temp =  helper(nums, target-nums[index], index-1, dp) || helper(nums, target, index-1, dp);
        if (temp == true){
            dp[index][target] = 1;
        } else {
            dp[index][target] = 2;
        }

        return temp;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 == 1) return  false;
        int target = sum/2;
        int[] [] dp =  new int [n][target+1];

        return helper(nums, target, n-1, dp);


    }
}