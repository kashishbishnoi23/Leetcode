class Solution {

    private int recursion(String text1, String text2, int i, int j, int[][] dp){

        if (i == text1.length() || j == text2.length()){
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j)){
            return 1 + recursion(text1, text2, i+1, j+1, dp);
        }

        return dp[i][j] =  Math.max(recursion(text1, text2, i+1, j, dp), recursion(text1, text2, i, j+1, dp));
    }
    public int minInsertions(String s) {
        // jo string me sabse lamba palindromic subsequence ban raha hai -> it already has letters for itself -> does'nt need any extra insertions -> so ham pehle longest palindromic subsequence ki length nikalenge 

        // longest common subsequence between s and its reverse:
        StringBuilder rev = new StringBuilder();
        int n = s.length();

        for (int i = n-1; i >= 0; i--){
            rev.append(s.charAt(i));
        }
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int length =  recursion(s, rev.toString(), 0, 0, dp); // length of the longest palindromic subsequence

        return s.length() - length;
    }
}