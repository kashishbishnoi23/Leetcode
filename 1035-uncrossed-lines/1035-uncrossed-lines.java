class Solution {

    private int LCS(int[] nums1, int[] nums2, int indx1, int indx2, int[][] dp){

        if (indx1 == nums1.length || indx2 == nums2.length) return 0;

        if (dp[indx1][indx2] != -1) return dp[indx1][indx2];
        
        int pick = Integer.MIN_VALUE;
        int notpick = Integer.MIN_VALUE;
        if (nums1[indx1] == nums2[indx2]){
            pick =  1 + LCS(nums1, nums2, indx1+1, indx2+1, dp);
        } else {
            notpick =  Math.max(LCS(nums1, nums2, indx1, indx2+1, dp), LCS(nums1, nums2, indx1+1, indx2, dp));
        }

        return dp[indx1][indx2] = Math.max(pick, notpick);


    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
         
        int n = nums1.length;
        int m = nums2.length;
        int[][]dp = new int[n][m];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return LCS(nums1, nums2, 0, 0, dp);
    }
}