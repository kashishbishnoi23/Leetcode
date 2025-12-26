class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        // direct tabulation:
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++){
            dp[n-1][j] = matrix[n-1][j];
        }

        for (int i = n-2; i >= 0; i--){
            for (int j = 0; j < m; j++){
                int curr = matrix[i][j];

                int left = Integer.MAX_VALUE;
                // left:
                if (j > 0){
                    left = dp[i+1][j-1];
                }

                // same:
                int same = dp[i+1][j];

                // right:
                int right = Integer.MAX_VALUE;

                if (j < m-1){
                    right = dp[i+1][j+1];
                }

                dp[i][j] = curr + Math.min(Math.min(left, same), right);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (int a : dp[0]){
            ans = Math.min(ans, a);
        }

        return ans;



    }
}