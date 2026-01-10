class Solution {

    private int recursion(int [] prices, int indx, int state, int k, int[][][] dp){
        if (k == 0) return 0;
        if (indx == prices.length){
            if (state == 1) return Integer.MIN_VALUE;
            return 0;
        }

        if (dp[indx][state][k] != -1) return dp[indx][state][k];
         
        int profit = 0;
        // if I can buy:
        if (state == 0){
            int buy = Integer.MIN_VALUE;
            int next = recursion(prices, indx+1, 1, k, dp);
            if (next != Integer.MIN_VALUE){
                buy = -prices[indx] + next;
            }

            int notbuy = recursion(prices, indx+1, 0, k, dp);

            profit = Math.max(buy, notbuy);
        } else {
            // I can only sell:
            int sell = prices[indx] + recursion(prices, indx+1, 0, k-1, dp);

            int notsell = recursion(prices, indx+1, 1, k, dp);

            profit = Math.max(sell, notsell);
        }

        return dp[indx][state][k] = profit;
    }
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return recursion(prices, 0, 0, 2, dp);

    }
}