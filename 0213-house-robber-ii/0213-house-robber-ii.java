class Solution {

    private int houserobber(int index, ArrayList <Integer>nums, int[] dp){

        if (index == 0) return nums.get(index);
        if (index < 0) return 0;

        if (dp[index] != -1) return dp[index];


        // pick the element:
        int pick = nums.get(index) + houserobber(index-2, nums, dp);

        // do not pick the element: 
        int notpick = houserobber(index-1, nums, dp);

        return dp[index] =  Math.max(pick, notpick);

    }

    
    public int rob(int[] nums) {

     // agar first lena hai to last chhodo, agar last lena ha to first chhodo -> create two arrays -> two cases -> the max of these is my ans


     ArrayList<Integer> temp1 = new ArrayList<>();
     ArrayList<Integer> temp2 = new ArrayList<>();
     int n = nums.length;

     if (n == 1) return nums[0];

     int[] dp1 = new int[n];
     int[]dp2 = new int[n];

     Arrays.fill(dp1, -1);
     Arrays.fill(dp2, -1);

     for (int i = 0; i < nums.length; i++){
        if (i != 0){
            temp1.add(nums[i]);
        }

        if (i != n-1){
            temp2.add(nums[i]);
        }
     }

     return Math.max(houserobber(n-2, temp1, dp1), houserobber(n-2, temp2, dp2));

    }
}