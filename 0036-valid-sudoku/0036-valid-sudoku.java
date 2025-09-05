class Solution {
    public boolean isValidSudoku(char[][] board) {

    //     int n = board.length;
    //     int m = board[0].length;
    //     HashMap<Character, Boolean> hashing = new HashMap<>();
    //     for (int k = 0; k < 3; k++){
    //         for (int i = 0; i < 3; i++){
    //             for (int j = 3*k; j < 3*k+3; j++){
    //                     if (board[i][j] != '.' && hashing.containsKey(board[i][j])){
    //                 // System.out.println("i = " + i + " j = " + j);
    //                 return false;
    //             }
    //             hashing.put(board[i][j], true);
    //             }
    //         }
    //         hashing.clear();
    //     }

      

    //     for (int k = 0; k < 3; k++){
    //         for (int i = 3; i <= 5; i++){
    //             for (int j = 3*k; j < 3*k+3; j++){
    //                     if (board[i][j] != '.' && hashing.containsKey(board[i][j])){
    //                 // System.out.println("i = " + i + " j = " + j);
    //                 return false;
    //             }
    //             hashing.put(board[i][j], true);
    //             }
    //         }
    //         hashing.clear();
    //     }


    //     for (int k = 0; k < 3; k++){
    //         for (int i = 6; i <= 8; i++){
    //             for (int j = 3*k; j < 3*k+3; j++){
    //                     if (board[i][j] != '.' && hashing.containsKey(board[i][j])){
    //                 return false;
    //             }
    //             hashing.put(board[i][j], true);
    //             }
    //         }
    //           hashing.clear();
    //     }

    // // each row :
    //  for (int i = 0; i < n; i++){
    //     HashMap<Character,Boolean> hashing1 = new HashMap<>();
    //         for (int j = 0; j < m; j++){
    //             if (board[i][j] != '.' && hashing1.containsKey(board[i][j])){
    //                 return false;
    //             }
    //             hashing1.put(board[i][j], true);
    //         }
    //     }

    //        for (int i = 0; i < m; i++){
    //     HashMap<Character,Boolean> hashing2 = new HashMap<>();
    //         for (int j = 0; j < n; j++){
    //             if (board[j][i] != '.' && hashing2.containsKey(board[j][i])){
    //                 return false;
    //             }
    //             hashing2.put(board[j][i], true);
    //         }
    //     }

    //     return true;

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