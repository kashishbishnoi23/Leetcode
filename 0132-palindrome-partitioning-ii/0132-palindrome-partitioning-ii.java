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

    private int recursion(int indx ,String s, int[] dp){
       int n = s.length();
       if (indx == n) return 0;

       if (dp[indx] != -1) return dp[indx];
        
       int min = Integer.MAX_VALUE;
       for(int j = indx; j < n; j++){
          if (isPalindrome(s.substring(indx, j+1))){
             int cost = 1 + recursion(j+1, s, dp);
             min = Math.min(min, cost);
          }
       }

       return dp[indx] = min;

    }
    public int minCut(String s) {
        int n = s.length();

        // if (isPalindrome(s)) return 0;

        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);

        dp[n-1] = 1;

        for (int i = n-2; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++){
                // check if i..j substring is palindrome:
                if (isPalindrome(s.substring(i, j+1))){
                    // int next = j+1 == n ? 
                    int cost = 1 + dp[j+1];
                    min = Math.min(min, cost);
                }

            }

            dp[i] = min;
        }
        // return recursion(0, s, dp)-1;

        return dp[0]-1;
    }
}