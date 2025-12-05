class Solution {

    private int dfs(int row, int col, int[][] matrix, int[][] dp){

        int[][] dirs = {{0, 1}, {1, 0}, {0,-1}, {-1,0}};

        if (dp[row][col] != -1)return dp[row][col];

        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        for (int[] dir : dirs){
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && matrix[newrow][newcol] > matrix[row][col]){
               
                int next = dfs(newrow, newcol, matrix, dp);
                max = Math.max(max, next);
            }
        }

        return dp[row][col] = 1 + max;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                count = Math.max(count, dfs(i, j, matrix, dp));

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        return count;

    }
}