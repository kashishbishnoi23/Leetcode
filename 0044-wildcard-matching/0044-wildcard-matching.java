class Solution {

    private boolean recursive(String s, String p, int i, int j, int[][] dp){

        if (i == -1 && j == -1) return true;
        // if (i == -1 || j == -1) return false;
        if (i == -1 && j > -1){
            boolean flag = true;
            while(j >= 0){
                if (p.charAt(j) != '*'){
                    flag = false;
                    break;
                }
                j--;
            }
            return flag;
        }

        if (j == -1) return false;

        if (dp[i][j] != -1){
            return dp[i][j] == 1;
        }

        if (p.charAt(j) == '*'){
            boolean a = recursive(s, p, i-1, j, dp) || recursive(s, p, i, j-1, dp);
           dp[i][j] = (a == true) ? 1 : 0;
           return a;
        } else if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            boolean b = recursive(s, p, i-1, j-1, dp);
            dp[i][j] = (b == true) ? 1 : 0;
            return b;

        }
        // return dp[i][j] =  false;
        dp[i][j] = 0;

        return false;
    }
    public boolean isMatch(String s, String p) {
        // if (p.equals("*")) return true;
        // boolean flag = true;
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return recursive(s, p, n-1, m-1, dp);



    }
}