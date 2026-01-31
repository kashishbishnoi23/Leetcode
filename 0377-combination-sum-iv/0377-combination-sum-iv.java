class Solution {

    private int recursion(int[] nums, int target, int[] dp){

        if (target == 0) return 1;

        if (target < 0) return 0;

        if (dp[target] != -1) return dp[target];
    
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > target) break;
            count += recursion(nums, target-nums[i], dp);
        }

        return dp[target] = count;

    }

    public int combinationSum4(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int [target+1];
        Arrays.fill(dp, -1);

        return recursion(nums, target, dp);
    }
}