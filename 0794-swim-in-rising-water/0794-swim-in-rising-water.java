class Solution {

    private boolean canReach(int mid, boolean [][] visited, int row, int col, int n, int [][] grid ){

        // check validity -> 
        if (!isValid(row, col, n) || visited[row][col] || grid[row][col] > mid ) return false; // if the current height > mid -> return false
        

        if (row == n-1 && col == n-1) return true; // if reached destination => return true

        visited[row][col] = true;

        int [][] directions = {{-1, 0}, {0,-1}, {0,1}, {1,0}};

        // go to all directions:
        for (int [] direction : directions){
            int newrow = row + direction[0];
            int newcol = col + direction[1];

            if (canReach(mid, visited, newrow, newcol, n, grid)){
                return true;
            }
        }

        return false;

    }

    private boolean isValid(int row, int col, int n){
       return row >= 0 && row < n && col >= 0 && col < n;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        // binary search:
        // find the max height of the elevation -> that's the max time that can be used to reach the destination:

        /*
        int maxHeight = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                maxHeight = Math.max(maxHeight, grid[i][j]);
                // itna time maximum lagega => cuz this is the max height of all elevations -> inse kam height wale bhi vo swim kr skta hai 
            }
        }

        int start = 0;
        int end = maxHeight;

        int mid = (start) + (end-start)/2;

        while(start <= end){
            mid = start + (end-start)/2;

            boolean [][] visited = new boolean [n][n];

            // check if we can reach in mid time:
            if (canReach(mid, visited, 0,0, n, grid)){ // dfs se check if we can reach in this time
                // try minimum time:
                end = mid-1;
            } else {
                // take more time:
                start = mid+1;
            }

            System.out.println("mid = " + mid);
        }

        return start;
        
        */

        // Solution 2 :  Dijistra algorithm:
        int time = grid[0][0];

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int [] {grid[0][0], 0, 0}); // starting -> height, row, col
        
        int [][] visited = new int [n][n];
        int [][] directions = {{-1, 0}, {0,-1}, {1, 0}, {0,1}};

        while(!pq.isEmpty()){
            int [] current = pq.poll();

            int height = current[0];
            int row = current[1];
            int col = current[2];
            time = Math.max(time, height);

            if (row == n-1 && col == n-1) break;

            // push your neighbours:
            for (int [] direction : directions){
                int newrow = row + direction[0];
                int newcol = col + direction[1];

                if (isValid(newrow, newcol, n) && visited[newrow][newcol] == 0){
                    visited[newrow][newcol] = 1;
                    pq.add(new int [] {grid[newrow][newcol], newrow, newcol});

                }
            }


        }

        return time;


        

    }
}