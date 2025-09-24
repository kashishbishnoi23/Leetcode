class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return true;
            if (nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }

            // find the sorted half:
            if (nums[start] <= nums[mid]){
                // first half is sorted
                if (target >= nums[start] && target <= nums[mid]){
                    end = mid;
                } else {
                    start = mid+1;
                }

            } else{
                // second half is sorted
                if (target >= nums[mid] && target <= nums[end]){
                    start = mid;
                } else {
                    end = mid-1;
                }
            }
        }

        return false;
    }
}