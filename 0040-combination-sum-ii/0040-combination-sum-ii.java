class Solution {

    private void recursive(int[] candidates, int indx, List<List<Integer>> ans, List<Integer> temp, int target){

        if (target == 0){
            List<Integer> curr = new ArrayList<>(temp);
            ans.add(curr);
            return;
        }
        
        for (int i = indx; i < candidates.length; i++){
            if (i > indx && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target) return;
            temp.add(candidates[i]);
            recursive(candidates, i+1, ans, temp, target-candidates[i]);
            if (!temp.isEmpty()) temp.remove(temp.size()-1);
        }

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);

        recursive(candidates, 0, ans, temp, target);


        
        

        // time comp -> O(2^n) -> for loop isnt generating O(n) at each level -> its giving call for remaining children at each indx -> this is just a new way of generating all the subsets -> total nodes -> O(2^n) 

        return ans;
    }
}