class Solution {

    private void recursive(List<List<Integer>> ans, List<Integer> temp, int k, int target, int[] nums, int indx){

        if (target < 0) return;

        if (k == 0){
            if (target == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if (indx == nums.length) return;


        // pick
        temp.add(nums[indx]);
        recursive(ans, temp, k-1, target-nums[indx], nums, indx+1);

        // not pick
        temp.remove(temp.size()-1);
        recursive(ans, temp, k, target, nums, indx+1);

        
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        int[] nums = {1,2,3,4,5,6,7,8,9};

        recursive(ans, temp, k, n, nums, 0);

        return ans;
    }
}