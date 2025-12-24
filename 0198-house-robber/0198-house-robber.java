class Solution {

    private int recursion(int index, int[] nums, int [] dp){
        if (index >= nums.length) return 0;

        if (dp[index] != -1) return dp[index];

        int pick = nums[index] + recursion(index+2, nums, dp);

        int notpick = recursion(index+1, nums, dp);

        return dp[index] =  Math.max(pick, notpick);
    }
    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recursion(0, nums, dp);
    }
}