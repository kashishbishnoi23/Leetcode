class Solution {


    private void recursion(int indx, int[] nums, List<Integer>temp, List<List<Integer>> ans){
        int n = nums.length;

        ans.add(new ArrayList<>(temp));
        if (indx == n) return;

        for(int i = indx; i < n; i++){
            if (i > indx && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            recursion(i+1, nums, temp, ans);
            temp.remove(temp.size()-1);
        }

    }

 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        recursion(0, nums, temp, ans);

        return ans;
    }
}