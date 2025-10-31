class Solution {

    private void swap(int first, int second, int[] nums){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int[] getSneakyNumbers(int[] nums) {
        // Arrays.sort(nums);
        int n = nums.length;
        int[] ans = new int[2];
        int index = 0;

        // for (int i = 1; i < n; i++){
        //     if (nums[i] == nums[i-1]){
        //         ans[index++] = nums[i];
        //     }
        // }
        // return ans;

        for (int i = 0; i < n; i++){
            // swap the number with the number at its correct position:
            int j = i;
            while(nums[nums[j]] != nums[j]){
                swap(j, nums[j], nums);
            }
        }

        ans[index++] = nums[n-2];
        ans[index++] = nums[n-1];
        return ans;

    


    }
}