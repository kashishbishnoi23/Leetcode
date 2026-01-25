class Solution {
    public int minPairSum(int[] nums) {
        int min = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start < end){
            min = Math.max(min, nums[start] + nums[end]);
            start++;
            end--;
        }

        return min;


    }
}