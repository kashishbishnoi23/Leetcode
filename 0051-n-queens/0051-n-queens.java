class Solution {


    private void recursive(int[][] board, int row, List<List<String>> ans){
        int n = board.length;
        if (row == n){
          List<String> temp = new ArrayList<>();
          for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++){
                 if (board[i][j] == 0){
                    sb.append('.');
                 } else {
                    sb.append('Q');
                 }
            }
            temp.add(sb.toString());
          }

          ans.add(temp);
          return;
        }

        for (int col = 0; col < n; col++){
            // can I put the queen here:
            if (isValid(board, row, col)){
                board[row][col] = 1;
                recursive(board, row+1, ans);
                board[row][col] = 0;          
            }
            
        }

        
    }

    private boolean isValid(int[][] board, int row, int col){
        if (row == 0) return true;
        int n = board.length;

        for (int i = 0; i < row; i++){
            if (board[i][col] == 1) return false;
        }

        int i = row;
        int j = col;

        while(i >= 0 && j >= 0){
            if (board[i][j] == 1) return false;
            i--;
            j--;
        }
        i = row;
        j = col;

        while(i >= 0 && j < n){
            if (board[i][j] == 1) return false;
            i--;
            j++;
        }  

        return true;
    }

    public List<List<String>> solveNQueens(int n) {
          int[][] board = new int[n][n];
          List<List<String>> ans = new ArrayList<>();


          recursive(board, 0, ans); // board and row


        

          return ans;
    }
}