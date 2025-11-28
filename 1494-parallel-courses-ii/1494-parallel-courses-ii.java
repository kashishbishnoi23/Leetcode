class Solution {
    int n, k;
    int[] prereqMask;
    Integer[] dp;

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        this.n = n;
        this.k = k;
        prereqMask = new int[n];
        dp = new Integer[1 << n];

        // Build prerequisite bitmask
        for (int[] r : relations) {
            int u = r[0] - 1;
            int v = r[1] - 1;
            prereqMask[v] |= (1 << u);
        }

        return solve(0);
    }

    // mask = completed courses bitmask
    private int solve(int mask) {
        if (mask == (1 << n) - 1) return 0; // all done
        if (dp[mask] != null) return dp[mask];

        int available = 0;

        // check which courses can be taken
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) { // not completed
                if ((mask & prereqMask[i]) == prereqMask[i]) {
                    available |= (1 << i);
                }
            }
        }

        // Remove already done ones
        available &= ~mask;

        int res = Integer.MAX_VALUE;

        // Try all subsets of available courses (<= k)
        for (int subset = available; subset > 0; subset = (subset - 1) & available) {
            if (Integer.bitCount(subset) <= k) {
                res = Math.min(res, 1 + solve(mask | subset));
            }
        }

        return dp[mask] = res;
    }
}



      
       

       



