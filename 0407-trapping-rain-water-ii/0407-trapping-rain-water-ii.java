class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare (a[0], b[0]));

        // push the boundaries and mark them visited:
        boolean [][] visited = new boolean [n][m];

        // first and last row:
        for (int col = 0; col < m; col ++){
            for (int row : new int [] {0, n-1}){
                visited[row][col] = true;
                pq.offer(new int [] {heightMap[row][col], row, col});
            }
        }

        // first and last col:
        for (int row = 0; row < n; row++){
            for (int col : new int[] {0, m-1}){
                visited[row][col] = true;
                pq.offer(new int[] {heightMap[row][col], row, col});
            }
        }
        

        int water = 0;

        int[][] directions = {{0,1}, {1, 0}, {0,-1}, {-1, 0}};


        while(!pq.isEmpty()){
            int [] current = pq.poll();
            int height = current[0];
            int row = current[1];
            int col = current[2];

            // minimum bahar nikaal liya -> go to its neighbours 
            for (int[] direction : directions){
                int newrow = row + direction[0];
                int newcol = col + direction[1];
                if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == false){
                     visited[newrow][newcol] = true;
                     int curr = heightMap[newrow][newcol];

                    // pani store tab hoga agar boundary current cell se badi hogi
                    if (height > curr){
                        water += height - curr;
                        // System.out.println("curr = " + curr + " water = " + water);
                    }

                    pq.offer(new int[] {Math.max(height, curr), newrow, newcol});
                }
            }
        }

        return water;

    }
}