class Solution {

    private int recursive(int[] nums1, int[] nums2, int i, int j, int[][] dp){

        if (i == nums1.length || j == nums2.length) return Integer.MIN_VALUE;

        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int take = nums1[i]*nums2[j];
        int next = recursive(nums1, nums2, i+1, j+1, dp);

        if (next != Integer.MIN_VALUE && (take + next) >= take){
            take += next;
        }    

        int nottake = Math.max(recursive(nums1, nums2, i, j+1, dp), recursive(nums1, nums2, i+1, j, dp));

        int ans =  Math.max(take, nottake);

        dp[i][j] = ans;
        // System.out.println("i = " + i + " j = " + j + " ans = " + ans);
        return ans;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        // for (int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], Integer.MAX_VALUE);
        // }

        // int ans = recursive(nums1, nums2, 0, 0, dp);

       

        dp[n-1][m-1] = nums1[n-1]*nums2[m-1]; // last cell


        // last row:
        for (int j = m-2; j >= 0; j--){
            dp[n-1][j] = Math.max(nums1[n-1]*nums2[j], dp[n-1][j+1]);
        }

        // last col:
        for (int i = n-2; i >= 0; i--){
            dp[i][m-1] = Math.max(nums1[i]*nums2[m-1], dp[i+1][m-1]);
        }

        for (int i = n-1; i >= 0; i--){
            for (int j = m-2; j >= 0; j--){
                // take:
                int take = nums1[i] * nums2[j] 
           + Math.max(0, (i+1 < n && j+1 < m) ? dp[i+1][j+1] : Integer.MIN_VALUE);


                int nottake = Integer.MIN_VALUE;

                int first = (i + 1 < n ) ? dp[i+1][j] : Integer.MIN_VALUE;
                int second = (j + 1 < m) ? dp[i][j+1] : Integer.MIN_VALUE;

                nottake = Math.max(first, second);
                dp[i][j] = Math.max(take, nottake); 
            }
        }

        return dp[0][0];
    }
}