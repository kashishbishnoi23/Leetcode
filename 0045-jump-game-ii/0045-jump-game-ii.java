class Solution {

    private int recursive(int[] nums, int index, int [] dp){
         
   
        if (index >= nums.length-1) return 0;
             if (dp[index] != Integer.MAX_VALUE) return dp[index];
        int min = Integer.MAX_VALUE;
        if (nums[index] == 0) return Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index]; i++){
            int call = recursive(nums, index+i, dp);
            if (call != Integer.MAX_VALUE){
                min = Math.min(min, 1+call);
            }
        }

        return dp[index] =  min;
    }
    public int jump(int[] nums) {

        int n = nums.length;
        int [] dp = new int [n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        return recursive(nums, 0, dp);
    }
}