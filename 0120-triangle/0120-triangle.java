class Solution {
    private int recursion(int row, int col, List<List<Integer>>triangle, int[][] dp){
        int n = triangle.size();
        
        if (row >= n ) return Integer.MAX_VALUE;
        int m = triangle.get(row).size();
        if (col >= m) return Integer.MAX_VALUE;
        int curr = triangle.get(row).get(col);

        if (row == n-1) return curr;

        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        // take jth of next:
        int first = Integer.MAX_VALUE;

        int next1 = recursion(row+1, col, triangle, dp);
        if (next1 != Integer.MAX_VALUE){
            first = curr + next1;
        }

        // take j+1 th of next:
        int second = Integer.MAX_VALUE;
        int next2 = recursion(row+1, col+1, triangle, dp);

        if (next2 != Integer.MAX_VALUE){
            second = curr + next2;
        }

        return dp[row][col] = Math.min(first, second);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // int[][] dp = new int[n][n];
        // for (int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], Integer.MAX_VALUE);
        // }
        // return recursion(0, 0, triangle, dp);

        int[] dp = new int[n];

        int[] next = new int[n];
        
        for (int i = 0; i < triangle.get(n-1).size(); i++){
            next[i] = triangle.get(n-1).get(i);
        }


        for (int i = n-2; i >= 0; i--){
            int size = triangle.get(i).size();
            int[] curr = new int[size];

            for (int j = 0; j < size; j++){
                curr[j] = triangle.get(i).get(j) + Math.min(next[j], next[j+1]);
            }

            next = curr;
        }

        return next[0];




    }
}