class Solution {

    // static int count = 0;

    // private void dfs(int row, int col, int[][] grid, int [][] visited){

    //     int n = grid.length;
    //     int m = grid[0].length;
    //     if (row < 0 || row >= n || col < 0 || col >= m) return;

    //     int [][] directions = {{-1, 0}, {0, -1}, {0,1}, {1, 0}};
    //     count ++;


    //     // go to all four directions:
    //     for (int [] direction : directions){
    //         int newrow = row + direction[0];
    //         int newcol = col + direction[1];
    //         if (newrow < 0 || newrow >= n || newcol < 0 || newcol >= m) continue;
    //         if (visited[newrow][newcol] == 0 && grid[newrow][newcol] == 1){
    //            visited[newrow][newcol] = 1;
    //            dfs(newrow, newcol, grid, visited);
    //         }
    //     }


    // }


    
    static int count = 0;
    static int maxArea = 0;

    static int [][] directions = {{0,1}, {1, 0}, {-1,0}, {0,-1}};

    private static void dfs(int row, int col, int [][] visited, int [][] grid){
        int n = grid.length;
        int m = grid[0].length;
        count ++;

        for (int [] direction : directions){
            int newrow = row + direction[0];
            int newcol = col + direction[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0 && grid[newrow][newcol] == 1){
                visited[newrow][newcol] = 1;
                dfs(newrow, newcol, visited, grid);
            }
        }


    }
    public int maxAreaOfIsland(int[][] grid) {
        count = 0;
        maxArea = 0;
        int n = grid.length;
        int m = grid[0].length;

        int [][] visited = new int [n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (visited[i][j] == 0 && grid[i][j] == 1){
                    visited[i][j] = 1;
                     dfs(i, j, visited, grid);
                     maxArea = Math.max(maxArea, count);
                     count = 0;
                }
            }
        }





        // int maxArea = 0;
        // int n = grid.length;
        // int m = grid[0].length;
        // int ans = 0;

        // int [][] visited = new int [n][m];

        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < m; j++){
        //         if (grid[i][j] == 0) continue;

        //         if (visited[i][j] == 0){
        //             count = 0;
        //             visited[i][j] = 1;
        //             dfs(i,j, grid, visited);
        //             ans = Math.max(ans, count);
        //         }

        //     }
        // }

        // return ans;

        return maxArea;
    }
}