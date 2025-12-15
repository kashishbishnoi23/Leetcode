class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // count the degree of all the cities:
        
        int[] degree = new int[n];

        int[][] ranks = new int[n][n];
        for (int[] road : roads){
            degree[road[0]] ++;
            degree[road[1]] ++;
            ranks[road[0]][road[1]] = -1;
            ranks[road[1]][road[0]] = -1;
        }

        int ans = 0;

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j) continue;
                ans = Math.max(ans, degree[i] + degree[j] + ranks[i][j]);
            }
        }

        return ans;






    }
}