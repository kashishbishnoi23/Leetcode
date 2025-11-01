class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int nextIndex = 1;
     
        for (int i = 1; i < n; i++){
            int curr = nums[i];
            if (curr > prev){
                prev = curr;
                nums[nextIndex] = curr;
                nextIndex++;
            }
        }

        return nextIndex;
        
    }
}