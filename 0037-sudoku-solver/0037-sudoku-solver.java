class Solution {

    private boolean solve(char[][] board){

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '.'){
                    // try to fill it using 1 to 9:
                    for (char ch = '1'; ch <= '9'; ch++){
                        if (isValid(board, i, j, ch)){
                            // agar valid hai:
                            board[i][j] = ch;
                            if (solve(board) == true){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char ch ){
        // kya ye already is row ya col me present hai??
        for (int l = 0; l < 9; l++){
            if (board[i][l] == ch || board[l][j] == ch) return false;

            
            // find the startRow and startCol of the box:
            int startRow = 3*(i/3);
            int startCol = 3*(j/3);

            int actualRow = startRow + (l/3);
            int actualCol = startCol + (l% 3);

            if (board[actualRow][actualCol] == ch) return false;


        }

        return true;
    }



    public void solveSudoku(char[][] board) {
        solve(board);
    }
}