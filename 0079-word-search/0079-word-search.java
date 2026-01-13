class Solution {


    private boolean recursive(int row, int col, char[][] board, String word, int indx, int[][] visited){

        visited[row][col] = 1;

        if (indx == word.length()-1) return true;

        int n = board.length;
        int m = board[0].length;

        int[][] directions = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int[] direction : directions){
            int newrow = row + direction[0];
            int newcol = col + direction[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0){
                if (board[newrow][newcol] == word.charAt(indx+1)){
                    if (recursive(newrow, newcol, board, word, indx+1, visited) == true){
                        return true;
                    }
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
                    if (recursive(i, j, board, word, 0, visited) == true){
                        return true;
                    }
                }
            }
        }

        return false;

    }
}