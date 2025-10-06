class Solution {

    private boolean canReach(int max, int[][] grid, int row, int col, boolean[][] visited){
         
         int n = grid.length;
         // base case:
         if (row == n-1 && col == n-1) return true;

         // mark as visited:
         visited[row][col] = true;
         int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

         // go to its neighbours:

        for (int [] direction : directions){
            int newrow = row + direction[0];
            int newcol = col + direction[1];

            if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < n && visited[newrow][newcol] == false && grid[newrow][newcol] <= max){
                visited[newrow][newcol] = true;
                if (canReach(max, grid, newrow, newcol, visited)) return true;

            }


        }

        return false;



    }
    public int swimInWater(int[][] grid) {
         
        // kisi bhi elevation pe ham tak swim kr skte hain if its height is less than or equal to the water level (t)

        // max time jo lag skta hai -> that's max value in the grid => us elevation ko doobne me max time lagega
        // Binary Search solution -> start = 0, end = max

        // find mid -> see if u can reach (n-1, n-1) in mid time -> if yes -> then minimize the time => by doing end = mid-1
        // if not possible to reach in mid time => time badhana padega => start = mid + 1
        
        /*
        int max = 0;

        // O(N^2)
        int n = grid.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                max = Math.max(max, grid[i][j]);
            }
        }

        int start = 0;
        int end = max;
         
        // max => N^2 -> O(N^2LOGN)
        while(start < end){
            int mid = start + (end - start )/2;
            // check if it is possible with mid:
            boolean[][] visited = new boolean[n][n];
            if (grid[0][0] > mid){
                start = mid+1;
                continue;
            }
            if (canReach(mid, grid, 0, 0, visited)){
                end = mid;
            } else {
                start = mid+1;
            }

        }

        return start;

        */



        // Solution 2 : Dijistra algorithm: at each point => move towards the minimum neighbour -> cuz it'll take minimum time to reach
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{grid[0][0], 0, 0}); // height, row, col
        int time = 0;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        int [][] directions = {{0,1}, {1,0}, {0,-1}, {-1, 0}};
        while(!pq.isEmpty()){
            int [] current = pq.poll();
            int height = current[0];
            int row = current[1];
            int col = current[2];

            // abhi I am standing at current elevation aur time hua ha t:
            time = Math.max(time, height);
            if (row == n-1 && col == n-1) return time;

            // go to its neighbours => push them -> pq will give u the shortest elevation to pick:

            for (int [] direction : directions){
                int newrow = row + direction[0];
                int newcol = col + direction[1];

                if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < n &&  visited[newrow][newcol] == false){
                    visited[newrow][newcol] = true;
                    pq.offer(new int []{grid[newrow][newcol], newrow, newcol});
                }
            }

        }

        return time;

    }
}