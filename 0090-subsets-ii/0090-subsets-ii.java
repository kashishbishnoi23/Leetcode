class Solution {

    private void recursive(int[] nums, int indx, List<List<Integer>> ans, List<Integer> temp){

        ans.add(new ArrayList<>(temp));
        
        for (int i = indx; i < nums.length; i++){
            if (i > indx && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            recursive(nums, i+1, ans, temp);

            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);

        recursive(nums, 0, ans, temp);

        return ans;
    }
}