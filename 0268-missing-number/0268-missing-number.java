class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        // int i = 0;

        for (int i = 0; i < n; i++){
            if (nums[i] == n) continue;
            while(nums[i] < n && nums[i] != i){
                 int temp = nums[nums[i]];
                 nums[nums[i]] = nums[i];
                 nums[i] = temp;
            }
        }

        for (int j = 0; j < n; j++){
            if (nums[j] != j) return j;
        }

        return n;
    }
}