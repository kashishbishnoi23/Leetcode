class Solution {

    private int recursion(int[] coins, int indx, int amount, int[][] dp){

        if (amount == 0) return 0;
         
        if (indx == coins.length || amount < 0) return Integer.MAX_VALUE;
        // make this amount:

        if (dp[indx][amount] != -1) return dp[indx][amount];
        // pick -> if I pick this coin -> I am adding 1 to the ans
        // int pick = 1 + recursion(coins, indx+1, amount-coins[indx]);
        int pick = Integer.MAX_VALUE;
        int next = recursion(coins, indx, amount-coins[indx], dp);

        if (next != Integer.MAX_VALUE){
            pick  = 1 + next;
        }

        int notpick = recursion(coins, indx+1, amount, dp);

        return dp[indx][amount] =  Math.min(pick, notpick);
        
    }
    public int coinChange(int[] coins, int amount) {
        // return recursion(coins, 0, amount) == Integer.MAX_VALUE
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = recursion(coins, 0, amount, dp);



        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}