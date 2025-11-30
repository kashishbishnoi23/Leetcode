class Solution {

    int MOD = (int)(1e9 + 7);

    private int dfs(int row, int col, int[][] dp, int[][] grid){
        if (dp[row][col] != -1) return dp[row][col];
        int n = grid.length;
        int m = grid[0].length;

        int[][] dirs = {{0,1}, {1, 0}, {0,-1}, {-1, 0}};
        int ways = 1;

        for (int [] dir : dirs){
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && grid[newrow][newcol] > grid[row][col]){
                ways = (ways + dfs(newrow, newcol, dp, grid)) % MOD;
            }
        }

        return dp[row][col] = ways;
    }

    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = (int)1e9 + 7;
        
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = (ans + dfs(i, j, dp, grid)) % MOD;
            }
        }

        return ans;

        
    }
}