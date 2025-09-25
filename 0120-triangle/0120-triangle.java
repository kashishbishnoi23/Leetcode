class Solution {

    private int recursive(List<List<Integer>> triangle, int row, int col, int[][] dp){

        if (row == triangle.size()) return 0;
        if (dp[row][col] != Integer.MIN_VALUE) return dp[row][col];

        // go to i:
        int first = triangle.get(row).get(col) + recursive(triangle, row+1, col, dp);

        // go to i+1
        int second = triangle.get(row).get(col) + recursive(triangle, row+1, col+1, dp);

        return dp[row][col] =  Math.min(first, second);

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) return triangle.get(0).get(0);

        int m = triangle.get(n-1).size();
        int [][] dp = new int [n][m];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // return recursive(triangle, 0, 0, dp);

        for (int i = 0; i < m; i++){
           dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for (int j = n-2; j >= 0; j--){
            for (int i = 0; i < triangle.get(j).size(); i++){
                int first = dp[j+1][i];

                int second = dp[j+1][i+1];
                // System.out.println("first = " + first);
                // System.out.println("second = " + second);

                // System.out.println(Math.min(first, second));

                dp[j][i] = triangle.get(j).get(i) + Math.min(first, second);
            }

            // System.out.println("col = " + j);

            // for (int ele : dp[j]){
            //     System.out.print(ele + " ");
            // }
            // System.out.println();
        }

        int ans = Integer.MAX_VALUE;
        for (int  ele : dp[0]){
            // System.out.println(ele);
            ans = Math.min(ans, ele);
        }

        return ans;


    }
}