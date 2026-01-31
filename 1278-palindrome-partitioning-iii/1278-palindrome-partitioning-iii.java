class Solution {

    private boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;

        while(start <= end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    private int findCost(String str){
        if (isPalindrome(str)) return 0;

        int start = 0;
        int end = str.length()-1;

        int cost = 0;
        while(start <= end){
            if (str.charAt(start) != str.charAt(end)){
                cost ++;
            }

            start ++;
            end --;
        }

        return cost;
    }

    private int recursion(int indx, String s, int partitions, int[][] dp){

        if (indx == s.length()){
            if (partitions == 0) return 0;
            return Integer.MAX_VALUE;
        }
        

        if (partitions == 0 && indx < s.length() || partitions < 0){
            return Integer.MAX_VALUE;
        }

        if (dp[indx][partitions] != -1) return dp[indx][partitions];
        
        int min = Integer.MAX_VALUE;
        for (int i = indx; i < s.length(); i++){
            int cost = findCost(s.substring(indx, i+1));
            int next = recursion(i+1, s, partitions-1, dp);

            if (next != Integer.MAX_VALUE){
                cost += next;
                min = Math.min(min, cost);
            }

        }

        return dp[indx][partitions] = min;

    }

    public int palindromePartition(String s, int k) {
        if (s.length() == k) return 0;
        int n = s.length();

        int[][] dp = new int[n][k+1];

        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return recursion(0, s, k, dp);
    }
}