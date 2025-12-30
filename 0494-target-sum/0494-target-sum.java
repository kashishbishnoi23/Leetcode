class Solution {

    private int recursive(int[] nums, int target, int indx){
       
        if (indx == nums.length){
            if (target == 0) return 1;
            return 0;
        }

        // take plus:
        int plus = recursive(nums, target-nums[indx], indx+1);

        int minus = recursive(nums, target+nums[indx], indx+1);

        return plus + minus;
    }


    public int findTargetSumWays(int[] nums, int target) {
        // return recursive(nums, target, 0);

        // if I pick + -> I need to find ways in which I will get target-nums[indx] , maanlo target is 3 and curr element is 2, agar mane sum me +2 liya hai, then I need to find +1 in remaining array, but agar mane -2 liya hai, I will need to find the number of ways in which I will get 5 -> 5-2 will give me my target (3)

        // yaha kuch elements honge -> jo sirf positive honge => S1 (sum of those elements), bache hue sare negative -> inka sum maan liya S2

        // ab we have to make sure -> S1 - S2 = target , yani how many partitions exist with this target -> count partition with this difference

        // S1 - S2 = target , S1 - (total - S1) = target, 2S1 - total = target, S1 = (target + total)/2, so find in how many ways S1 exist
        int total = 0;
        for (int num : nums){
            total += num;
        }

        if ((total+target) % 2 == 1 || target > total || target < (-total)) return 0;

        // if (target == -total && target != 0) return 1;

        int subset1 = (target + total)/2;

        int n = nums.length;

        // max sum subset1 tak hi jayega -> decides the size of dp array:
        int[][] dp = new int[n][subset1+1];

        for (int i = 0; i < n; i++){
            if (nums[0] == 0){
                dp[i][0] = 2;
            } else {
                dp[i][0] = 1;
            }
        }

        System.out.println(dp[0][0]);

        if (nums[0] != 0){
            if (nums[0] <= subset1){
            dp[0][nums[0]] = 1;

            }
        }

        for (int i = 1; i < n; i++){
            for (int j =  0; j <= subset1; j++){

                if (j < nums[i]){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }


                int nottake = dp[i-1][j];

                int take = dp[i-1][j-nums[i]];

                dp[i][j] = nottake + take;
            }
        }

        return dp[n-1][subset1];






    }
}