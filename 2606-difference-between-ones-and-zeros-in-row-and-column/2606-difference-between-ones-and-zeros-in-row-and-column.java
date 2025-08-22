class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int [][] rowCount = new int [n][2];
        int [][] colCount = new int [m][2];

        for (int i = 0; i < n; i++){
            int onesRow = 0;
            int zeroesRow = 0;
            for (int j = 0; j < m; j++){
                 if (grid[i][j] == 0){
                    zeroesRow++;
                 } else {
                    onesRow ++;
                 }
            }

            rowCount[i][0] = zeroesRow;
            rowCount[i][1] = onesRow;
        }



        for (int i = 0; i < m ; i++){
            int onesCol = 0;
            int zeroesCol = 0;
            for (int j = 0; j < n; j++){
                if (grid[j][i] == 0){
                    zeroesCol++;
                } else {
                    onesCol++;
                }
            }
            colCount[i][0] = zeroesCol;
            colCount[i][1] = onesCol;

        }

        int[][] diff = new int[n][m];

        for (int i = 0; i < n;  i++){
            for (int j = 0; j < m; j++){
                int onesRow = rowCount[i][1];
                int zeroesRow = rowCount[i][0];
                int onesCol = colCount[j][1];
                int zeroesCol = colCount[j][0];

                diff[i][j] = onesRow + onesCol - zeroesRow - zeroesCol;
            }
        }

        return diff;



    }
}