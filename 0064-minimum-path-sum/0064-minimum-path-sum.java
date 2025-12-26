class Solution {

    private int recursion(int row, int col, int[][]grid, int[][] dp){
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m) return Integer.MAX_VALUE;

        if (row == n-1 && col == m-1) return grid[row][col];

        if (dp[row][col] != -1) return dp[row][col];

        // right:
        // int right = grid[row][col] + recursion(row, col+1, grid);
        int right = Integer.MAX_VALUE;
        int next1 = recursion(row, col+1, grid, dp);
        if (next1 != Integer.MAX_VALUE){
            right = grid[row][col] + next1;
        }

        // down:
        // int down = grid[row][col] + recursion(row+1, col, grid);
        int down = Integer.MAX_VALUE;
        int next2 = recursion(row+1, col, grid, dp);

        if (next2 != Integer.MAX_VALUE){
            down = grid[row][col] + next2;
        }

        return dp[row][col] = Math.min(right, down);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return recursion(0, 0, grid, dp);
    }
}