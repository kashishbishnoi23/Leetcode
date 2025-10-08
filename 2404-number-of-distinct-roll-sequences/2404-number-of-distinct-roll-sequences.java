class Solution {

    int MOD = (int)(1e9 + 7);

    private int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a%b);
    }


    private int recursion(int i, int n, int last, int secondLast, int [][][] dp){
        if (i == n) return 1;

        if (dp[i][last][secondLast] != -1) return dp[i][last][secondLast];

        int total = 0;
        for (int curr = 1; curr <= 6; curr++){
            if (curr == last || curr == secondLast) continue;

            if (last != 0 && gcd(curr, last) != 1) continue;

            total = (total + recursion(i+1, n, curr, last, dp)) % MOD;

        }

        return dp[i][last][secondLast] =  total;




    }
     
    public int distinctSequences(int n) {

        int [][][] dp = new int[n+1][7][7];

        for (int i = 0; i <= n; i++){
            for (int j = 0; j < 7; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return recursion(0, n, 0, 0, dp);
    }
}