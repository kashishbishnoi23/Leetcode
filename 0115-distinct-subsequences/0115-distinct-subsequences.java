class Solution {
    
    private int recursion(String s, String t, int i, int j, int[][] dp){

        if (j == -1) return 1;
        if (i == -1) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        
        // if they match -> like agar s = babgbag, t = bag , if I have found g -> find ba in remaining s + keep looking for another g in the remaining s
        if (s.charAt(i) == t.charAt(j)){
            return dp[i][j] =  recursion(s, t, i-1, j-1, dp) + recursion(s, t, i-1, j, dp);
        } else {
            return dp[i][j] =  recursion(s, t, i-1, j, dp);
        }
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return recursion(s, t, n-1, m-1, dp);
    }
}