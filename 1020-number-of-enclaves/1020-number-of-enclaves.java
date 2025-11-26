class Solution {

    private void dfs(int row, int col, int[][] visited, int[][] grid){
        visited[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int [] direction : directions){
            int newrow = row + direction[0];
            int newcol = col + direction[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0 && grid[newrow][newcol] == 1){
                visited[newrow][newcol] = 1;
                dfs(newrow, newcol, visited, grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] visited = new int[n][m];

     for (int col  : new int [] {0, m-1}){
         for (int i = 0; i < n; i++){
             if (grid[i][col] == 1 && visited[i][col] == 0){
                visited[i][col] = 1;
                dfs(i, col, visited, grid);
             }
        }
     }

     for (int row : new int[] {0, n-1}){
        for (int j = 0; j < m; j++){
            if (grid[row][j] == 1 && visited[row][j] == 0){
                visited[row][j] = 1;
                dfs(row, j, visited, grid);
            }
        }
     }

     int count = 0;

     for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            if (visited[i][j] == 0 && grid[i][j] == 1) count++;
        }
     }

return count;
  
    }
}