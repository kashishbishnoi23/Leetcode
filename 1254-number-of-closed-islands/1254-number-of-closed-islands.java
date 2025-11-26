class Solution {
    

    int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private void helper(int row, int col, int[][] grid, int[][] visited){
         
         int n = grid.length;
         int m = grid[0].length;
         for (int [] dir : directions){
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0 && grid[newrow][newcol] == 0){
                visited[newrow][newcol] = 1;
                grid[newrow][newcol] = 1;
                dfs(newrow, newcol, grid, visited);
            }
         }
    }

        private void dfs(int row, int col, int[][] grid, int[][] visited){
         
         int n = grid.length;
         int m = grid[0].length;
         for (int [] dir : directions){
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0 && grid[newrow][newcol] == 0){
                visited[newrow][newcol] = 1;
                dfs(newrow, newcol, grid, visited);
            }
         }
    }



    public int closedIsland(int[][] grid) {
        // cover all the 0s at border
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        
        // turn the 0s at border as 1: 
        for (int col : new int [] {0, m-1}){
            for (int i = 0; i < n; i++){
                if (grid[i][col] == 0 && visited[i][col] == 0){
                    visited[i][col] = 1;
                    helper(i, col, grid, visited);
                }
            }
        }

        for (int row : new int[]{0, n-1}){
            for (int j = 0; j < m; j++){
                if (grid[row][j] == 0 && visited[row][j] == 0){
                    visited[row][j] = 1;
                    helper(row, j, grid, visited);
                }
            }
        }

        // count the number of closed islands:
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (visited[i][j] == 0 && grid[i][j] == 0){
                    visited[i][j] = 1;
                    dfs(i, j, visited, grid);
                    count ++;
                }
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        return count;


    }
}