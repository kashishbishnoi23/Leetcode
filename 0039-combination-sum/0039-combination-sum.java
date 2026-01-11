class Solution {
    private void recursion(int[] candidates, int indx, int sum, List<List<Integer>> ans, List<Integer> temp){

        if (sum < 0 || indx == candidates.length){
            return;
        }

        if (sum == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // pick
        if (candidates[indx] <= sum){
            temp.add(candidates[indx]);
            recursion(candidates, indx, sum-candidates[indx], ans, temp);
            temp.remove(temp.size()-1);
        }

        // not pick
        recursion(candidates, indx+1, sum, ans, temp);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(candidates, 0, target, ans, temp);
        return ans;
    }
}