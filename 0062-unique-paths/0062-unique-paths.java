class Solution {

    private int recursion(int row, int col, int[][] dp){
        if (row < 1 || col < 1) return 0;

        if (dp[row][col] != -1) return dp[row][col];

        if (row == 1 && col == 1) return 1;

        // go down
        int down = recursion(row-1, col, dp);
        // go right
        int right = recursion(row, col-1, dp);

        return dp[row][col] = down + right;

    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++){
            Arrays.fill(dp[i], -1);
        }
        return recursion(m, n, dp);
    }
}