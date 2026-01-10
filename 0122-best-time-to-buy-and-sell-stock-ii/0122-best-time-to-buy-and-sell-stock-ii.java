class Solution {

    private int recursion(int[] prices, int indx, int state, int[][] dp){

        // base case:
        if (indx == prices.length){
            if (state == 1) return Integer.MIN_VALUE;
            return 0;
        }

        if (dp[indx][state] != -1) return dp[indx][state];

        if (state == 0){
            int buy = Integer.MIN_VALUE;
            int next =  recursion(prices, indx+1, 1, dp);
            int notbuy = recursion(prices, indx+1, 0, dp);
            if (next != Integer.MIN_VALUE){
                buy = -prices[indx] + next;
            }
            return dp[indx][state] =  Math.max(buy, notbuy);
        } else {
            // u can only sell:
            int sell = prices[indx] + recursion(prices, indx+1, 0, dp);
            int notsell = recursion(prices, indx+1, 1, dp);

            return dp[indx][state] =  Math.max(sell, notsell);
        }

        // return 0;


    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        // return recursion(prices, 0, 0, dp); // if state is 0 , I can buy , if state is 1 , I can only sell

        dp[n-1][0] = 0; // last stock cannot be bought:
        dp[n-1][1] = prices[n-1];
        for (int i = n-2; i >= 0; i--){
            for (int state = 0; state <= 1; state++){

                int profit = 0;
                if (state == 0){
                    // I can only buy:
                    int buy = -prices[i] + dp[i+1][1];
                    int notbuy = dp[i+1][0];
                    profit = Math.max(buy, notbuy);
                } else {
                    int sell = prices[i] + dp[i+1][0];
                    int notsell = dp[i+1][1];
                    profit = Math.max(sell, notsell);
                }
                dp[i][state] = profit;
            }
        }

        return dp[0][0];


    }
}