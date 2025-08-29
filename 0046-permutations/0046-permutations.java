class Solution {

    private void swap(int i, int index, int[]nums){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    private void recursive(int index, int[] nums, List<List<Integer>>ans){
        
        int n = nums.length;
        if (index == n){
            // ans.add(new ArrayList<>(Arrays.asList(nums)));
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : nums){
                temp.add(num);
            }

            ans.add(temp);
            return;
        }

        for (int i = index; i < n; i++){
             // swap i with index in nums:
             swap(i, index, nums);
             recursive(index+1, nums, ans);
             swap(i, index, nums);
        }


    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        recursive(0,nums, ans);

        return ans;
    }
}