class Solution {

    private int recursion(int[][] obstacleGrid, int row, int col, int[][] dp){
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if (row == n-1 && col == m-1) return 1;


        if (row < 0 || row >= n || col < 0 || col >= m || obstacleGrid[row][col] == 1){
            return 0;
        }

        if (dp[row][col] != -1) return dp[row][col];

        int down = recursion(obstacleGrid, row+1, col, dp);

        int right = recursion(obstacleGrid, row, col+1, dp);

        return dp[row][col] = down + right;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int [][] dp = new int [n][m];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        if (obstacleGrid[n-1][m-1] == 1) return 0;
        return recursion(obstacleGrid, 0, 0, dp);
    }
}