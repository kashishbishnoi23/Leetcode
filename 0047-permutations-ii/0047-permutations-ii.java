class Solution {

    private void swap(int [] nums, int i, int index){
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
    private void recursive(int index, int[] nums, List<List<Integer>> ans){
           int n = nums.length;

           if (index == n){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : nums){
                temp.add(num);
            }

            ans.add(temp);
            return;
           }

           HashSet<Integer> hashing = new HashSet<>();

           for (int i = index; i < n; i++){
            // if ith index element has been already used for index, don't use it again:
              if (hashing.contains(nums[i])) continue;
              hashing.add(nums[i]);
              swap(nums, i, index);
              recursive(index+1, nums, ans);
              swap(nums, i, index);
           }

    }
        public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        recursive(0, nums, ans);

        return ans;
        
        


    }
}