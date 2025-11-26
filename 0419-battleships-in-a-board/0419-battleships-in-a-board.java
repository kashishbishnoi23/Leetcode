class Solution {

    private void dfs(int row, int col, char[][] board, int[][] visited, boolean column){

        int n = board.length;
        int m = board[0].length;

        if (row >= n || col >= m || board[row][col] == '.')  return;
     // mark current as visited:
        visited[row][col] = 1;
        if (column){
            dfs(row, col+1,board, visited, column);
        } else {
            dfs(row+1, col,board, visited, column);
        }

   

    }
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int ans = 0;
        int[][] visited = new int[n][m];

        // use dfs:
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == 'X'){
                    boolean col = false; // row is true
                    if (j < m-1 && board[i][j+1] == 'X'){
                        col = true; 
                    }
                    if (visited[i][j] == 0){
                    dfs(i, j, board, visited, col);
                    ans++;
                    }
                }
            }
        }

        return ans;
    }
}