class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        // for (int i = 0; i < n; i++){
        //     int buy = prices[i];
        //     for (int j = i+1; j < n; j++){
        //         int sell = prices[j];
        //         if (sell <= buy) continue;

        //         maxProfit = Math.max(maxProfit, sell-buy);
        //     }
        // }

        int [] right = new int [n];
        right[n-1] = prices[n-1];

        for (int i = n-2; i >= 0; i--){
            right[i] = Math.max(prices[i], right[i+1]);
        }

        for (int j = 0; j < n; j++){
            maxProfit = Math.max(maxProfit, Math.abs(prices[j]-right[j]));
        }

        return maxProfit;
    }
}