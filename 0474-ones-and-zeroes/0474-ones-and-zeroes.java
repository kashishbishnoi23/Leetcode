class Solution {

    private int recursion(ArrayList<int[]> list, int index, int m, int n, int zeroes, int ones, int [][][] dp){
        
        if (index == list.size()) return 0;
        // can we pick?

        if (dp[index][zeroes][ones] != -1) return dp[index][zeroes][ones];
        int pick = 0;
        int zero = list.get(index)[0];
        int one = list.get(index)[1];
        
        if (zeroes + zero <= m && ones + one <= n){
            pick = 1 + recursion(list, index+1, m, n, zeroes+zero, ones+one, dp);
        }

        int notpick = recursion(list, index+1, m, n, zeroes, ones, dp);

        return dp[index][zeroes][ones] =  Math.max(pick, notpick);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        
        ArrayList<int []> list = new ArrayList<>();
   
        for (String str : strs){
            int zeroes = 0;
            int ones = 0;
            for (char ch : str.toCharArray()){
                if (ch == '0') zeroes++;
                else ones++;
            }
            int[] arr = new int[2];
            arr[0] = zeroes;
            arr[1] = ones;
            list.add(arr);
        }
        int size = list.size();

        int[][][] dp = new int[size][m+1][n+1];

        for (int i = 0; i < size; i++){
            for (int j = 0; j <= m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return recursion(list, 0, m, n, 0, 0, dp);

    }
}