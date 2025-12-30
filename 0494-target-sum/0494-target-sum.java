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
        return recursive(nums, target, 0);
    }
}