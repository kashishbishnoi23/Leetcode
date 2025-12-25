class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        // I have to find unique paths such that in each path -> I reach from start to end while covering all the non-obstacle points exactly once

        // find the starting row and starting col:
        int sr = 0;
        int sc = 0;
        int total = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] != -1) total ++;
            

            if (grid[i][j] == 1){
                sr = i;
                sc = j;
            }
        }

    }
        return dfs(grid, sr, sc, total);


    }

    private int dfs(int[][] grid, int row, int col, int remain){
        int n = grid.length;
        int m = grid[0].length;

        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == -1) return 0;

        if (grid[row][col] == 2 && remain == 1){
            return 1;
        }

        // mark the current node as visited by making it -1:
        int temp = grid[row][col];
        grid[row][col] = -1;

        // now go to all the four directions:

        int up = dfs(grid, row-1, col, remain-1);
        int down = dfs(grid, row+1, col, remain-1);
        int left = dfs(grid, row, col-1, remain-1);
        int right = dfs(grid, row, col+1, remain-1);

        grid[row][col] = temp; // backtracking
 
        return up + down + left + right;
        
    }
}