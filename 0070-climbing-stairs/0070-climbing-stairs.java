class Solution {

    private int recursion(int steps, int[] dp){

        if (steps == 0) return 1;

        if (steps < 0) return 0;
        if (dp[steps] != -1) return dp[steps];

        // take 1 step:
        int one = recursion(steps-1, dp);


        // take 2 steps:
        int two = recursion(steps-2, dp);

        return dp[steps] = one + two;
    }

    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recursion(n, dp);
    }
}