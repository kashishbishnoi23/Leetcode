class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 1;

        while(j < n){
            while(j < n && nums[j] == nums[i]){
                j++;
            }
            
            if (j == n) break;
            nums[i+1] = nums[j];
            i++;
            j++;
        }

        return i+1;
    }
}