class Solution {
    public boolean isValidSudoku(char[][] board) {
          int n = board.length;
    int m = board[0].length;

    boolean [][] rows = new boolean[9][10];
    boolean [][] cols = new boolean[9][10];
    boolean [][] boxes = new boolean[9][10];
    
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            if (board[i][j] == '.') continue;
            int k = board[i][j] - '0';
            if (rows[i][k] || cols[j][k]){
                return false;
            } else {
                rows[i][k] = cols[j][k] = true;
            }
            int quarter = i/3;
            // int boxcol = k;
            int col = j / 3;
            int boxrow = 3*quarter + col;
            if (boxes[boxrow][k]){
                return false;
            } else {
                boxes[boxrow][k] = true;
            }
             
        }
    }

    return true;
    }
}