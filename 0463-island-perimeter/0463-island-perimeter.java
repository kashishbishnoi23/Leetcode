class Solution {

    private void  dfs(int row, int col, int[][] grid, int[][] visited){
        visited[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        

        for (int [] dir : directions){
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0 && grid[newrow][newcol] == 1){
                visited[newrow][newcol] = 1;
               dfs(newrow, newcol, grid, visited);
            }

        }
         
        visited[row][col] = 0;
        for (int[] dir : directions){
            int newrow = row + dir[0];
            int newcol = col + dir[1];
            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && grid[newrow][newcol] == 1){
                visited[row][col] ++;
            }
        }



    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1){
                   count ++;
                }
            }
        }
        if (count == 1) return 4;

        boolean flag = false;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 1){
                    dfs(i, j, grid, visited);
                    flag = true;
                    break;
                }
            }
            if (flag)break;

        }

        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                // System.out.print(visited[i][j] + " ");
                if (visited[i][j] == 0) continue;
               ans += 4 - visited[i][j];
            }
            System.out.println();
        }

        return ans;
        
    }
}