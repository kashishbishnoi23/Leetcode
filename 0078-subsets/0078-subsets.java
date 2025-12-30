class Solution {

    private void recursion(List<List<Integer>> ans, List<Integer> temp,int[] nums, int indx){

        if (indx == nums.length){
            List<Integer> res = new ArrayList<>();
            res.addAll(temp);

            ans.add(res);
            return;
        }

        // pick
        temp.add(nums[indx]);

        recursion(ans, temp, nums, indx+1);

        // do not pick

        if (!temp.isEmpty()){
            temp.remove(temp.size()-1);
            recursion(ans, temp, nums, indx+1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        // pick not pick

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        recursion(ans, temp, nums, 0);

        return ans;
    }
}