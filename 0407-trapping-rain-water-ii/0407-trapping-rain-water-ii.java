class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        int water = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
           Integer.compare(a[0], b[0])
        );

        boolean [][] visited = new boolean[n][m];

        // push the boundaries to the pq and mark them visited:

        // first and last row:
        for (int col = 0; col < m ; col++){
            for (int row : new int[]{0,  n-1}){
                visited[row][col] = true;
                pq.offer(new int []{heightMap[row][col], row, col});
            }
        }

        // first col and last col:
        for (int row = 0; row < n; row++){
            for (int col : new int []{0, m-1}){
                visited[row][col] = true;
                pq.offer(new int[] {heightMap[row][col], row, col});
            }
        }

        int [][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while(!pq.isEmpty()){
            // pick the minimum boundary:
            int[] minimum = pq.poll();
            int height = minimum[0];
            int row = minimum[1];
            int col = minimum[2];

            // get its neighbours: 
            for (int [] direction : directions){
                int neighbourRow = row + direction[0];
                int neighbourCol = col + direction[1];

                
                if (neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && neighbourCol < m && visited[neighbourRow][neighbourCol] == false){
                    visited[neighbourRow][neighbourCol] = true;
                    int neighbourHeight = heightMap[neighbourRow][neighbourCol];
                    // calculate water:

                    // can it store water:
                    int waterStored = height - neighbourHeight;

                    if (waterStored > 0){
                        water += waterStored;
                    }
                pq.offer(new int[] {Math.max(height,neighbourHeight), neighbourRow, neighbourCol});
                }

            }
        
        }

        return water;






    }
}