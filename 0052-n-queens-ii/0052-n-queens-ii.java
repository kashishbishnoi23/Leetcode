class Solution {

    private int recursive(int[][] board, int row){
        int n = board.length;
        if (row == n){
           return 1;
        }
        
        int total = 0;
        for (int col = 0; col < n; col++){
            // can I put the queen here:
            if (isValid(board, row, col)){
                board[row][col] = 1;
                total += recursive(board, row+1);
                board[row][col] = 0;          
            }
            
        }

        return total;

        
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
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];

        return recursive(board, 0); // board and row
    }
}