class Solution {

    private void recursive(int n,int[][] filled, int row, List<List<String>> ans){

        if (row == n){
            List<String> path = new ArrayList<>();
            for (int i = 0; i < n; i++){
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < n; j++){
                     if (filled[i][j] == 0){
                        temp.append(".");
                     } else {
                        temp.append("Q");
                     }
                }
                path.add(temp.toString());
            }
            ans.add(path);
            return;

        }
         
         // fill the current row and current col , then move to the next row:
         // is it okay to fill the current col:
         for (int col = 0; col < n; col++){
            if (isValid(filled, row, col, n)){
                filled[row][col] = 1;
                // go to the next row:
                recursive(n, filled, row+1, ans);
                filled[row][col] = 0; // try another col and go again

            }
         }


    }

    private boolean isValid(int[][] filled, int row, int col, int n){
        for (int i = 0; i < row; i++){
            int diff = row-i;
            int[] temp = {-diff, 0, diff};

            for (int d : temp){
                int newcol = col + d;
                if (newcol >= 0 && newcol < n){
                    if (filled[i][newcol] == 1) return false;
                }

            }
        }

        return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        // List<String> temp = new ArrayList<>();

        int[][] filled = new int[n][n];

        recursive(n, filled, 0, ans);

        return ans;
    }
}