class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        // create visited array:
        int [][] dp = new int [n][m];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[] {0, 0,0, 2});

        int [][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
   
        while(!pq.isEmpty()){
            int [] current = pq.poll();
            int currTime = current[0];
            int currRow = current[1];
            int currCol = current[2];
            int prevTime = current[3];

            // if we have reached target, return currTime:
            if (currRow == n-1 && currCol == m-1) return currTime;

            // if u have reached this point at a better time, continue:
            if (dp[currRow][currCol] <= currTime) continue;

            dp[currRow][currCol] = currTime;

            // go to all the neighbours:
            for (int [] dir : directions){
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                // if it is valid and unvisited:
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && dp[nextRow][nextCol] == Integer.MAX_VALUE){
                    // calculate the new time:
                    int travelTime = prevTime == 2 ? 1 : 2;
                    int nextTime = travelTime + Math.max(currTime, moveTime[nextRow][nextCol]);
                    pq.add(new int [] {nextTime, nextRow, nextCol, travelTime});
                }
            }
        }

        return -1;

    }
}