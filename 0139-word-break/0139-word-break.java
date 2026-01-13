class Solution {

    private boolean recursion(String s , int indx, Set<String> st, int[] dp){
        
        if (indx == s.length()){
            return true;
        }
        if (dp[indx] != -1){
            return dp[indx] == 1;
        }
        for (int i = indx; i < s.length(); i++){
            String str = s.substring(indx, i+1);

            if (st.contains(str)){
                if (recursion(s, i+1, st, dp) == true){
                    dp[indx] = 1;
                    return true;
                }
            }
        }
        dp[indx] = 0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> st = new HashSet<>();
        for(String str : wordDict){
            st.add(str);
        }
        int n = s.length();

        // boolean[] dp = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recursion(s, 0, st, dp);
    }
}