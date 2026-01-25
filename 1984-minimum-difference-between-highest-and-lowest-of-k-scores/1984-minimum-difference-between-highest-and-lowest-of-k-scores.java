class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(end < k){
           min = Math.min(min, nums[end]);
           max = Math.max(max, nums[end]);
           end ++;
        }

        int diff = max - min;
        start++;

        while(end < n){
            min = nums[start];
            max = nums[end];
            diff = Math.min(diff, max-min);
            System.out.println(nums[start] + " "  + nums[end] + " " + diff);
            start++;
            end++;
        }
        return diff;
    }
}