class Solution {

    private int recursion(int[] coins, int amount, int index, int target, int[][] dp){
        if (target == amount) return 0; 

        if (index == coins.length || target > amount ) return Integer.MAX_VALUE;
        
        if (dp[index][target] != -1) return dp[index][target];

       int pick = Integer.MAX_VALUE;
    if (coins[index] <= amount && target + coins[index] <= amount) {
        int next = recursion(coins, amount, index, target + coins[index], dp);
        if (next != Integer.MAX_VALUE) {  // avoid overflow
            pick = 1 + next;
        }
    }

        int nonpick = recursion(coins, amount, index+1, target, dp);

        return dp[index][target] =  Math.min(pick, nonpick);


    }
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = recursion(coins, amount, 0, 0, dp);

        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
        // Arrays.sort(coins);

        // // reverse coins:
        // int start = 0;
        // int end = n-1;

        // while(start < end){
        //     int temp = coins[start];
        //     coins[start] = coins[end];
        //     coins[end] = temp;
        //     start++;
        //     end--;
        // }

        // int target = 0;
        // int i = 0;
        // int ans = 0;

        // while(target < amount && i < n){
        //     int curr = coins[i];

        //     while(target + curr <= amount){
        //         target += curr;
        //         ans ++;
        //     }
        //     i++;

        // }

        // if (target < amount) return -1;
        // return ans;
    }
}