class Solution {


    public String longestPalindrome(String s) {
        
        if (s.length() <= 1) return s;
        int n = s.length();

        int maxLength = 1;

        int start = 0;
        int end = 0;

        boolean[][] dp = new boolean[n][n];

       // i -> end, j -> start
        for (int i = 0; i < n; i++){
            dp[i][i] = true; // single character is always palindrome
            for (int j = 0; j < i; j++){
                // kya j...i tak ka substring palindrome ha ya nahi ??
                
                // j is start, i is start => check if they match 
                if (s.charAt(i) == s.charAt(j) && ((i-j) <= 2 || dp[j+1][i-1])){
                    if ((i-j+1) > maxLength){
                        maxLength = i-j+1;
                        start = j;
                        end = i;
                    }
                    dp[j][i] = true;
                }
            }
        }

        return s.substring(start, end+1);

        
    
    }
}