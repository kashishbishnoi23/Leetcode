class Solution {

    private int recursion(int[] nums, int index, int target, int[][] dp){
        // pick:
        if(index >= nums.length){
            if (target == 0) return 1;
            return 0;
        }
        if (target < 0) return 0;

        if (dp[index][target] != -1) return dp[index][target];

        int pick = recursion(nums, index+1, target-nums[index], dp);


        // not pick:
        int notpick = recursion(nums, index+1, target, dp);

        // return pick + notpick;
        int ans = 0;
        if (pick == 0 && notpick == 0){
            ans =  0;
        } else {
            ans = 1;
        }

        return dp[index][target] = ans;

    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums){
            total += num;
        }
        if (total % 2 == 1) return false;
        int n = nums.length;
        int target = total/2;
        int[][] dp = new int[n][target+1];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return recursion(nums, 0, target, dp) == 1;
    }
}