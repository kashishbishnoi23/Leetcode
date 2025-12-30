class Solution {

    private int recursive(List<Integer> nums, int target, int indx, int[][] dp){

        if (target == 0) return 0;

        if (target < 0 || indx == nums.size()) return Integer.MIN_VALUE;


        if (dp[indx][target] != -1) return dp[indx][target];

        // pick
        int pick = Integer.MIN_VALUE;
        if (nums.get(indx) <= target){
            int next = recursive(nums, target-nums.get(indx), indx+1, dp);

            if (next != Integer.MIN_VALUE){
            pick = 1 + next;
            }
        }


        // not pick
        int notpick = recursive(nums, target, indx+1, dp);

        return dp[indx][target] = Math.max(pick, notpick);
    }

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {

        int n = nums.size();

        int[][] dp = new int[n][target+1];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans  = recursive(nums, target, 0, dp);
        return ans == Integer.MIN_VALUE ? -1 : ans;

    }
}