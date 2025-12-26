class Solution {

    private int recursion(int[][] grid, int row, int col, int[][] dp){

        int n = grid.length;
        if (row == n-1) return grid[row][col];

        int min = Integer.MAX_VALUE;
        int curr = grid[row][col];

        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        for (int i = 0; i < n; i++){
            if (i == col) continue;
            min = Math.min(min, curr + recursion(grid, row+1, i, dp));
        }

        // System.out.println(row + "  " + col + "  " + min);



        return dp[row][col] = min;

    }
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int min = Integer.MAX_VALUE;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++){
            min = Math.min(min, recursion(grid, 0, i, dp));
        }
        // return recursion(grid, 0, 0);
        return min;
    }
}