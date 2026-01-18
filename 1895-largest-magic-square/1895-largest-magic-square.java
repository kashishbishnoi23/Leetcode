class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int side = Math.min(n, m);

        while(side > 0){
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (i+side <= n && j+side <= m ){
                    if (isValid(i, j, grid, side)){
                        return side;
                    } 
                } 
            }
        }
         
        side--;
        }

        return 0;
    }

    private boolean isValid(int row, int col, int[][] grid, int side){
        int n = row+side;
        int m = col+side;
        int sum = 0;
        
        // row
        for (int i = row; i < n; i++){
            int sumn = 0;
            for (int j = col; j < m; j++){
                sumn += grid[i][j];
            }

            if (i == row) sum = sumn;
            else if (sum != sumn) return false;
        }

        // columns
        for (int i = col; i < m; i++){
            int sumn = 0;
            for (int j = row; j < n; j++){
                sumn += grid[j][i];
            }
            if (sum != sumn) return false;
        }

        // main diagonal
        int sumn = 0;
        for (int k = 0; k < side; k++){
            sumn += grid[row+k][col+k];
        }

        if (sum != sumn) return false;

        sumn = 0;
        for (int k = 0; k < side; k++){
            sumn += grid[row+k][col+side-1-k];
        }

        if (sum != sumn) return false;

        return true;


    }
}