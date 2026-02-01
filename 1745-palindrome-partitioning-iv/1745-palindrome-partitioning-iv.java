class Solution {

    // private boolean isPalindrome(String s){
    //     int start = 0;
    //     int end = s.length()-1;

    //     while(start < end){
    //         if (s.charAt(start) != s.charAt(end)) return false;
    //         start ++;
    //         end --;
    //     }

    //     return true;
    // }




    public boolean checkPartitioning(String s) {

        // TLE maar gaya -> 90/91 test cases passed
        int n = s.length();

        // ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        // for (int i = 0; i <= n; i++){
        //     arr.add(new ArrayList<>());
        // }

        // arr.get(n-1).add(1);
        // arr.get(n).add(0);

        boolean[][] pal = new boolean[n+1][n+1];


        for (int i = n-1; i >= 0; i--){
            for (int j = i; j < n; j++){
                // substring -> from i to j -> starts at i and ends at j 

                if (s.charAt(i) == s.charAt(j)){
                    if (j-i <= 2 || pal[i+1][j-1]){
                        pal[i][j] = true;
                    }
                }
            }
        }

        // for (int i = n-2; i >= 0; i--){
        //     for (int j = i; j < n; j++){
        //        if (pal[i][j] == true){
        //             ArrayList<Integer> next = arr.get(j+1);
        //             for (int k = 0; k < next.size();k++){
        //                 if (next.get(k) >= 3) break;
        //                 int cost = 1 + next.get(k);
        //                 arr.get(i).add(cost);
        //             }
        //        }
        //     }
        //     Collections.sort(arr.get(i));
        // }

        // for (int a : arr.get(0)){
        //     if (a == 3) return true;
        // }

        // return false;

        boolean [][] dp = new boolean[n+1][4]; // will tell ki kya ith index pe -> k -> 0 se leke k = 3 tak partitions possible hai ya nahi
       
        dp[n][0] = true;

        for (int i =  n-1; i >= 0; i--){
            for (int j = i; j < n; j++){
                if (pal[i][j] == true){
                    for (int k = 1; k <= 3; k++){
                        if (dp[j+1][k-1] == true){
                            dp[i][k] = true;
                        }
                    }
                }
            }
        }


        return dp[0][3];












    }
}