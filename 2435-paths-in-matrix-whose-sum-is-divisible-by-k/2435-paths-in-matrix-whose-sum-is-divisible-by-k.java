class Solution {

    static final int MOD = 1000000007;

    private int recursion(int[][] grid, int row, int col, int k, int sum){
        int n = grid.length;
        int m = grid[0].length;
        
        if (row >= n || col >= m) return 0;
          // check for the curr:
        int rem = grid[row][col] % k;
        int next = (sum + rem) % k;

        if (row == n-1 && col == m-1){
            if (next == 0) return 1;
            return 0;
        } 

        int down = recursion(grid, row+1, col, k, next);

        int right = recursion(grid, row, col+1, k, next);

        return (down + right) % MOD;

    }
    public int numberOfPaths(int[][] grid, int k) {
        // return recursion(grid, 0, 0, k, 0);
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][k];

        dp[0][0][grid[0][0] % k] = 1;

        // tabulation:
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0 && j == 0) continue;
                int rem = grid[i][j] % k; 
                for (int r = 0; r < k; r++){

                    // take from top:

                    // top:
                    if (i > 0){
                        if (dp[i-1][j][r] > 0){
                            int prev = r;
                            int newrem = (prev + rem) % k;
                            dp[i][j][newrem] = (dp[i][j][newrem] + dp[i-1][j][r]) % MOD; 
                        }
                    }

                    // take from left:
                    if (j > 0){
                        if (dp[i][j-1][r] > 0){
                            int prev = r;
                            int newrem = (r + rem) % k;
                            dp[i][j][newrem] = (dp[i][j][newrem] + dp[i][j-1][r]) % MOD;
                        }
                    }


                }
            }
        }

        // int count = 0;
        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < m; j++){
        //         System.out.println(i + " " + j);
        //         for (int r = 0; r < k; r++){
        //             System.out.print(dp[i][j][r] + " ");
        //         }
        //         System.out.println();
        //     }
        // }

        return dp[n-1][m-1][0];



    }
}