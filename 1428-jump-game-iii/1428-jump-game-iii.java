class Solution {
    private boolean canReach(int[] arr, int index, HashMap<Integer, Boolean> hashing, int [] dp){
      
        if (index >= arr.length || index < 0 || hashing.getOrDefault(index, false) == true) return false;
        if (dp[index] == 0) return false;
        if (dp[index] == 1) return true;

        if (arr[index] == 0) return true;

        // jump to left:
        hashing.put(index, true);
        boolean left = canReach(arr, index-arr[index], hashing, dp);

        // jump to right:
        hashing.put(index, false);
        boolean right = canReach(arr, index+arr[index], hashing, dp);
        boolean ans = left || right;
        if (ans == true){
            dp[index] = 1;
        } else {
            dp[index] = 0;
        }

        return ans;


    }
    public boolean canReach(int[] arr, int start) {
        HashMap<Integer, Boolean> hashing = new HashMap<>();
        int n = arr.length;
        int [] dp = new int [n];
        Arrays.fill(dp, 2);
        return canReach(arr, start, hashing, dp);
    }
}