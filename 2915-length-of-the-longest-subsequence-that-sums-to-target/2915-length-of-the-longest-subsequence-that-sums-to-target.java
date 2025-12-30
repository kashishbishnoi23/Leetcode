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

        for (int i = 0; i < n; i++){
            dp[i][0] = 0; // har index pe 0 target banane k liye 0 hi elements chahiye
        }

        // 0th index wale element ko 0th index tak banane k liye max 1 hi element chahiye
        // dp[0][nums.get(0)] = 1;

        // int ans  = recursive(nums, target, 0, dp);
        // return ans == Integer.MIN_VALUE ? -1 : ans;

        for (int i = 0; i < n; i++){
            for (int j = 1; j <= target; j++){
                if (i == 0){
                    // I can only take this element , there are no prev elements:
                    if (j == nums.get(0)){
                        dp[0][j] = 1;
                    }
                    continue;
                }

                if (j < nums.get(i)){
                    dp[i][j] = dp[i-1][j];
                    continue; 
                } 

                
                int nottake = dp[i-1][j]; // pichle index tak is sum ko banane k liye kitne elements lage

                // int take = 1 + dp[i-1][j-nums[i]];
                int take = -1;
                int prev = dp[i-1][j-nums.get(i)];
                if (prev != -1){
                   take = 1 + prev;
                }
                // agar is element ko lenge to 1 element iska add hoga + bache hue sum ko banane me pichle index pe kitne elements lage -> for example, j is 4, and nums[i] is 1 -> to 1 element 1 khud hua plus pichle index pe 3 banane me max kitne elements use hue 

                dp[i][j] = Math.max(nottake, take);

            }
        }

        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j <= target; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return dp[n-1][target];

    }
}