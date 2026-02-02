class Solution {

    private void recursion(int indx, int[] nums, List<Integer>temp, List<List<Integer>> ans, int k, int target){


        if (temp.size() == k){
            if (target == 0){
                ans.add(new ArrayList<>(temp));
            } 
            return;
        }
        if (indx == nums.length) return;


        // pick 
        temp.add(nums[indx]);

        recursion(indx+1, nums, temp, ans, k, target-nums[indx]);

        temp.remove(temp.size()-1);
        // not pick

        recursion(indx+1, nums, temp, ans, k, target);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        recursion(0, nums, temp, ans, k, n);

        return ans;
    }
}