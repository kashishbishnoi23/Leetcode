class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n-1;

        while(mid <= high){
            if (nums[mid] == 0){
                // swap mid with low:
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1){
                mid++;
            } else {
                // swap with high:
                int temp = nums[high];
                nums[high] = nums[mid];
                high--;
                nums[mid] = temp;
            }
        }

        
    }
}