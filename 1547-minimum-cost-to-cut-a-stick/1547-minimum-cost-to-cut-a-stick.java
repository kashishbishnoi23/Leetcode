class Solution {

    private int recursion(int i, int j , int[] cuts, int[][] dp){

        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++){
            // k denotes the first cut position:
            int cost = cuts[j+1] - cuts[i-1] + recursion(i, k-1, cuts, dp) + recursion(k+1, j, cuts, dp);

            // cuts[j+1] - cuts[i-1] is the length of the rod being cut
            min = Math.min(min, cost); 
        }

        return dp[i][j] = min;
    }
    public int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts); // to make subproblems independent:
        int[] cuts2 = new int[cuts.length+2];
        cuts2[0] = 0;
        cuts2[cuts2.length-1] = n;

        for (int i = 1; i <= cuts.length; i++){
            cuts2[i] = cuts[i-1];
        }

        int m = cuts2.length;

        int[][] dp = new int[m][m];

        // for (int i = 0; i < m; i++){
        //     Arrays.fill(dp[i], -1);
        // }

        // return recursion(1, cuts.length, cuts2, dp); // i, j, cuts
        int l = cuts.length;

        for (int i = l; i >= 1; i--){
            for (int j = i; j <= l; j++){
                int min = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++){
                    int cost = cuts2[j+1] - cuts2[i-1] + dp[i][k-1] + dp[k+1][j];
                min = Math.min(min, cost);

                }

                dp[i][j] = min;

            }

        }

        return dp[1][l];
    }
}