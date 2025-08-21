class Solution {

    int [][] directions = {{1,0}, {0,1}, {-1, 0}, {0,-1}};

    private void dfs(int row, int col, int [][] visited, int [][] grid, int [] perimeter){
        int n = grid.length;
        int m = grid[0].length;

        // mark it as visited and count how much it contributes:
        for (int [] direction : directions){
            int newrow = row + direction[0];
            int newcol = col + direction[1];

            if (newrow < 0 || newrow >= n || newcol < 0 || newcol >= m || grid[newrow][newcol] == 0){
                perimeter[0]++;
            }      

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0 & grid[newrow][newcol] == 1){
                visited[newrow][newcol] = 1;
                dfs(newrow, newcol, visited, grid, perimeter);
            }
        }

    }
    public int islandPerimeter(int[][] grid) {
        int[] perimeter = {0};
        int rows = grid.length;
        int cols = grid[0].length;
        int [][] visited = new int [rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1 && visited[i][j] == 0){
                    // land found -> cover all the land components:
                    visited[i][j] = 1;
                    dfs(i, j, visited, grid, perimeter);
                }
            }
        }

        return perimeter[0];
    }
}