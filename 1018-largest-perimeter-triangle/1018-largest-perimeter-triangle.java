class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int max = 0;
    
        for (int i = 2; i < n; i++){
            // i is largest side:
            // find the valid sides , then pick their max sum:
            int left = 0;
            int right = i-1;
           
            while(left < right){
            if (nums[left] + nums[right] > nums[i]){
                max = Math.max(max, nums[right] + nums[right-1] + nums[i]);
                break;
            } else {
                left++;
            }

            }

        }

        return max;
    }
}