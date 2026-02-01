class Solution {


    public String longestPalindrome(String s) {
        
        if (s.length() <= 1) return s;
        int n = s.length();

        // int maxLength = 1;

        // int start = 0;
        // int end = 0;
    

        // boolean[][] dp = new boolean[n][n];

        // this is not very similar to LCS -> cuz isme continuity break hoti hai -> isliye recursion se krna thoda mushkil hai


        // basic intution -> i marks the end of the substring , j marks the start -> j se i tak ka substring palindrome hai ya nahi h -> as I keep getting new lengths of palindromes -> change the maxLength, start (j) and end (i)

        // start aur end ke saare combinations check krlo 

       // i -> end, j -> start
        // for (int i = 0; i < n; i++){
        //     dp[i][i] = true; // single character is always palindrome
        //     for (int j = 0; j < i; j++){
        //         // kya j...i tak ka substring palindrome ha ya nahi ??
                
        //         // j is start, i is start => check if they match 
        //         if (s.charAt(i) == s.charAt(j) && ((i-j) <= 2 || dp[j+1][i-1])){
        //             if ((i-j+1) > maxLength){
        //                 maxLength = i-j+1;
        //                 start = j;
        //                 end = i;
        //             }
        //             dp[j][i] = true;
        //         }
        //     }
        // }

        // return s.substring(start, end+1);

        // expand around the center approach: O(N^2)

        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++){
            
            // 2 types ki length of ho skti hain for being a palindrome -> even and odd 
            

            // odd length:
            int len1 = expand(s, i, i);

            // even length:
            int len2 = expand(s, i, i+1);

            int maxLength = Math.max(len1, len2);

            if (maxLength > end-start+1){
                start = i - (maxLength -1)/2; // i is the center -> usse start pe jaare hain using length
                end = i + (maxLength)/2; 
            }

        }

        return s.substring(start, end+1);
    
    
    }

    public int expand(String s, int left, int right){
        int n = s.length();
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }
}