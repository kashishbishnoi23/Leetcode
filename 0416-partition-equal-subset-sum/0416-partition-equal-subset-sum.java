class Solution {

    // private int recursion(int[] nums, int index, int target, int[][] dp){
    //     // pick:
    //     if(index >= nums.length){
    //         if (target == 0) return 1;
    //         return 0;
    //     }
    //     if (target < 0) return 0;

    //     if (dp[index][target] != -1) return dp[index][target];

    //     int pick = recursion(nums, index+1, target-nums[index], dp);


    //     // not pick:
    //     int notpick = recursion(nums, index+1, target, dp);

    //     // return pick + notpick;
    //     int ans = 0;
    //     if (pick == 0 && notpick == 0){
    //         ans =  0;
    //     } else {
    //         ans = 1;
    //     }

    //     return dp[index][target] = ans;

    // }

    public boolean canPartition(int[] nums) {
        // int total = 0;
        // for (int num : nums){
        //     total += num;
        // }
        // if (total % 2 == 1) return false;
        // int n = nums.length;
        // int target = total/2;
        // int[][] dp = new int[n][target+1];

        // for (int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }



        // return recursion(nums, 0, target, dp) == 1;

        int n = nums.length;

        // dp array banayenge -> [n][target] -> har index pe check krenge -> 1 ... target tak sare numbers la paana possible hai ya nahi:

        int target = 0;
        for (int i = 0; i < n; i++){
            target += nums[i];
        }

        if (target % 2 == 1) return false;

        target /= 2;

        boolean[][] dp = new boolean[n][target+1];

        for (int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        
        if (nums[0] <= target){
        dp[0][nums[0]] = true;  
        }   

        for (int i = 1; i < n; i++){
            for(int j = 1; j <= target; j++){
               boolean notpick = dp[i-1][j];


               boolean pick = false;
               if (nums[i] <= j){
                  pick = dp[i-1][j-nums[i]];
               }

               dp[i][j] = pick || notpick;

            }
        }

        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j <= target; j++){
        //         System.out.print(dp[i][j] + "  ");
        //     }
        //     System.out.println();
        // }

        return dp[n-1][target];



    }
}