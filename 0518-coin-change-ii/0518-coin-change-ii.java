class Solution {

    private int recursive(int amount, int indx, int[] coins, int[][] dp){

        if (amount == 0) return 1;

        if (amount < 0 || indx == coins.length) return 0;

        if (dp[indx][amount] != -1) return dp[indx][amount];

        int pick = recursive(amount-coins[indx], indx, coins, dp);

        int notpick = recursive(amount, indx+1, coins, dp);

        return  dp[indx][amount] = pick + notpick;


    }
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return recursive(amount, 0, coins, dp);
    }
}