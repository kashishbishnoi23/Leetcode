class Solution {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
         int [][] visited = new int [n][m];

        // push all the rotten oranges:
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (grid[i][j] == 2){
                    queue.offer(new int [] {i, j});
                    visited[i][j] = 1;
                }
            }
        }

       
        int t = 0;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while(!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                int [] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int[] direction : directions){
                    int newrow = row + direction[0];
                    int newcol = col + direction[1];

                    if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && grid[newrow][newcol] == 1 && visited[newrow][newcol] == 0){
                        visited[newrow][newcol] = 1;
                        queue.offer(new int [] {newrow, newcol});
                    }
                }

                
            }
            if (queue.isEmpty()) break;

        
            t++;
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (visited[i][j] == 0 && grid[i][j] == 1){
                    return -1;
                }
            }
        }



        return t;




    }
}