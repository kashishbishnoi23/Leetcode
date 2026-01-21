class Solution {

    private int recursion(int i, int j, int[] arr, int[][] dp){
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++){
            int cost = arr[i-1]*arr[k]*arr[j+1] + recursion(i, k-1, arr, dp) + recursion(k+1, j, arr, dp);
            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        arr[arr.length-1] = 1;

        for(int i = 0; i < n; i++){
           arr[i+1] = nums[i];
        }

        int[][] dp = new int[n+2][n+2];
        for (int i = 0; i < n+2; i++){
            Arrays.fill(dp[i], -1);
        }

        return recursion(1, n, arr, dp);
    }
}