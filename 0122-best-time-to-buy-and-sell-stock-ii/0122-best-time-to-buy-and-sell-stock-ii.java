class Solution {

    private int recursive(int[] prices, int index, boolean canBuy, boolean canSell, int [][][] dp){

        if (index == prices.length) return 0;
        int row = (canBuy == true) ? 1 : 0;
        int col = (canSell == true) ? 1 : 0;

        if (dp[index][row][col] != -1) return dp[index][row][col];
        
        int buy, notbuy, sell, notsell;
        buy = notbuy = sell = notsell = 0;
        // buy
        if (canBuy == true){
           buy = -prices[index] + recursive(prices, index+1, false, true, dp);
           notbuy = recursive(prices, index+1, true, false, dp);
        }

        // sell
        if (canSell == true){
            sell = prices[index] + recursive(prices, index+1, true, false, dp);

            notsell = recursive(prices, index+1, false, true, dp);
        }

        return dp[index][row][col] =  Math.max(buy, Math.max(notbuy, Math.max(sell, notsell)));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][] dp = new int[n][4][2];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < 4; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
         
        return recursive(prices, 0, true, false, dp);
    }
}