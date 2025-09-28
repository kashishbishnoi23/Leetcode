class Solution {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        int [][] dp = new int [n][m];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
           Integer.compare(a[0], b[0])
        );

        pq.add(new int[]{0,0,0});

        int [][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        while(!pq.isEmpty()){
            int [] current = pq.poll();
            int currTime = current[0];
            int currRow = current[1];
            int currCol = current[2];

            if (currRow == n-1 && currCol == m-1)return currTime;

            // if I have already reached dp[currRow][currCol] at a better time, continue
            if (dp[currRow][currCol] <= currTime) continue;

            dp[currRow][currCol] = currTime;

            // go to all the four directions:
            for (int [] dir : directions){
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && dp[nextRow][nextCol] == Integer.MAX_VALUE){
                    int nextTime = 1 + Math.max(moveTime[nextRow][nextCol], currTime);
                    pq.add(new int [] {nextTime, nextRow, nextCol});
                }
            }



        }

        return -1;





        
    }
}