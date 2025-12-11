class Solution {

    int[][] dir = {{0,1}, {1, 0}, {0,-1}, {-1, 0}};

    private boolean isPossible(int time, int[][] grid, int row, int col, int[][] visited){

        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] > time || grid[n-1][m-1] > time) return false;


        if (row == n-1 && col == m-1){
            if (grid[row][col] <= time) return true;
            return false;
        }
        
        visited[row][col] = 1;
        

        for (int[] d : dir){
            int nrow = row + d[0];
            int ncol = col + d[1];

            if (nrow >= 0 && nrow < n &&  ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && grid[nrow][ncol] <= time){
                visited[nrow][ncol] = 1;
                if (isPossible(time, grid, nrow, ncol, visited) == true) return true;
            }
        }

        return false;
        
    }

    
    public int swimInWater(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                max = Math.max(max, grid[i][j]);
            }
        }

        int start = 0;
        int end = max;

        while(start <= end){
            int mid = start + (end-start)/2;
            int[][] visited = new int[n][m];

            if (isPossible(mid, grid, 0, 0, visited)){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        if (grid[0][0] > start) return grid[0][0];

        return start;




    }
}