class Solution {

    int MOD = (int) 1e9 + 7;

    private int recursive(int row, int col, int[][] grid, int k , int mod, int[][][] dp){
        int n = grid.length;
        int m = grid[0].length;
        if (row >= n || col >= m) return 0;
            int newmod = (mod + grid[row][col]) % k;
        if (row == n-1 && col == m-1){
            // System.out.println(sum + grid[row][col]);
            return newmod == 0 ? 1 : 0;
           
        }
    

        if (dp[row][col][newmod] != -1){
            return dp[row][col][newmod];
        }
        // go right:
        int right = recursive(row, col + 1, grid, k, newmod, dp);
        // go down
        int down = recursive(row+1, col, grid, k, newmod, dp);

        return dp[row][col][newmod] = ((right % MOD) + (down % MOD)) % MOD;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][k];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
         
        return recursive(0, 0, grid, k, 0, dp);
    }
}