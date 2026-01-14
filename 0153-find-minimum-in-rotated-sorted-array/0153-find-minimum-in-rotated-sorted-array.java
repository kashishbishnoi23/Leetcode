class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[n-1] >= nums[0]) return nums[0];


        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if (mid > 0 && nums[mid] < nums[mid-1]) return nums[mid];

            // where u at??
            if (nums[mid] > nums[0]){
                start = mid + 1;
            } else {
                end = mid-1;
            }
        }

        return 0;

        
    }
}