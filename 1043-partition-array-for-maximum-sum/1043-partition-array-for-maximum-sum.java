class Solution {

    private int recursion(int i, int[] arr, int k, int[] dp){
        int n = arr.length;
        if (i >= n) return 0;
        int maxSum = 0;

        if (dp[i] != -1) return dp[i];

        int max = 0;
        for (int j = i; j < n && j < i+k ; j++){
            max = Math.max(max, arr[j]);
            int len = j-i+1;
            int sum = max*len + recursion(j+1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }

        // System.out.println("i = " + i + " " + maxSum);

        return dp[i] = maxSum;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
         
        int n = arr.length;
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return recursion(0, arr, k, dp);
        // dp[n-1] = arr[n-1];
        for (int i = n-1; i >= 0; i--){
            int max = 0;
            int maxSum = 0;
            for(int j = i; j < n && j < i+k; j++){
               max = Math.max(max, arr[j]);
               int len = j-i+1;
               int sum = len*max + dp[j+1];
               maxSum = Math.max(maxSum, sum);
            }

            dp[i] = maxSum;
            System.out.println(dp[i]);

        }



        return dp[0];
    }
}