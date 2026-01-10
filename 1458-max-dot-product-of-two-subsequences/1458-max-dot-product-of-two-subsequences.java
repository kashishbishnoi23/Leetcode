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
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        int ans = recursive(nums1, nums2, 0, 0, dp);

        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return ans;
    }
}