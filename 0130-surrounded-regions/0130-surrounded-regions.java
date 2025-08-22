class Solution {

    // static int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    // private void dfs(int row, int col, int[][] visited, char[][] board){

    //     // go to neighbours:
    //     int n = board.length;
    //     int m = board[0].length;

    //     for (int[] direction : directions){
    //         int nrow = row + direction[0];
    //         int ncol = col + direction[1];

    //         if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m){
    //             if (board[nrow][ncol] == 'O' && visited[nrow][ncol] == 0){
    //                 visited[nrow][ncol] = 1;
    //                 dfs(nrow, ncol, visited, board);
    //             }
    //         }
    //     }

    // }

    static int [][] directions = {{0,1}, {1,0}, {-1, 0}, {0,-1}};
   
   private static void dfs(int row, int col, int[][] visited, char [][] board ){
   int n = board.length;
   int m = board[0].length;

   for (int [] direction : directions){
      int newrow = row + direction[0];
      int newcol = col + direction[1];

      if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0 && board[newrow][newcol] == 'O'){
        visited[newrow][newcol] = 1;
        dfs(newrow, newcol, visited, board);
      }
   }

 }






    public void solve(char[][] board) {
        // int n = board.length;
        // int m = board[0].length;

        // int[][] visited = new int [n][m];

        // // first row:
        // for (int i = 0; i < m; i++){
        //     if (visited[0][i] == 0 && board[0][i] == 'O'){
        //         visited[0][i] = 1;
        //         dfs(0, i, visited, board);
        //     }
        // }
        
        // // last row:
        // for (int j = 0; j < m; j++){
        //     if (visited[n-1][j] == 0 && board[n-1][j] == 'O'){
        //         visited[n-1][j] = 1;
        //         dfs(n-1, j, visited, board);
        //     }
        // }

        // // first col:
        // for (int k = 0; k < n; k++){
        //     if(visited[k][0] == 0 && board[k][0] == 'O'){
        //         visited[k][0] = 1;
        //         dfs(k, 0, visited, board);
        //     }
        // }

        // // last col:
        // for (int l = 0; l < n; l++){
        //     if (visited[l][m-1] == 0 && board[l][m-1] == 'O'){
        //         visited[l][m-1] = 1;
        //         dfs(l, m-1, visited, board);
        //     }
        // }

        // // leave the ones that are visited 
        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < m; j++){
        //        if (visited[i][j] == 0 && board[i][j] == 'O'){
        //         board[i][j] = 'X';
        //        }
        //     }
        // }



      


      int n = board.length;
      int m = board[0].length;

      int [][] visited = new int [n][m];

      // first row:
      for (int j = 0; j < m; j++){
        if (visited[0][j] == 0 && board[0][j] == 'O'){
            visited[0][j] = 2;
            dfs(0, j, visited, board);
        }
      }

      // last row:
      for (int j = 0; j < m; j++){
        if (visited[n-1][j] == 0 && board[n-1][j] == 'O'){
            visited[n-1][j] = 1;
            dfs(n-1, j, visited, board);
        }
      }

      // first col:
      for (int i = 0; i < n; i++){
        if (visited[i][0] == 0 && board[i][0] == 'O'){
            visited[i][0] = 1;
            dfs(i,0, visited, board);
        }
      }

      // last col:
      for (int j = 0; j < n; j++){
        if (visited[j][m-1] == 0 && board[j][m-1] == 'O'){
            visited[j][m-1] = 1;
            dfs(j, m-1, visited, board);
        }
      }

      for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            if (board[i][j] == 'O' && visited[i][j] == 0){
                board[i][j] = 'X';
            }
        }
      }

      
    





    }
}