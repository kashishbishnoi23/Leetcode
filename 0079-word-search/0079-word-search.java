class Solution {
   

   private boolean recursion(int row, int col, char[][] board, String word, int indx, int[][] visited){

      if (indx == word.length()) return true;

      int n = board.length;
      int m = board[0].length;
       
      visited[row][col] = 1;

      int[][] dirs = {{0,1},{1, 0},{-1, 0}, {0, -1}};

       // go to its neighbours:
       for (int[] dir : dirs){
           int newrow = row + dir[0];
           int newcol = col + dir[1];

           if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0){
            if (board[newrow][newcol] == word.charAt(indx)){
                if (recursion(newrow, newcol, board, word, indx+1, visited) == true) return true;
            }
           }
       }


       visited[row][col] = 0;


       return false;

   }

 

    public boolean exist(char[][] board, String word) {
        
       int n = board.length;
       int m = board[0].length;

       for (int i = 0; i < n; i++){
         for (int j = 0; j < m; j++){
            if (board[i][j] == word.charAt(0)){
                int[][] visited = new int[n][m];
                if (recursion(i, j, board, word, 1, visited) == true) return true;
                
            }

         }
       }

       return false;
    
    }
}