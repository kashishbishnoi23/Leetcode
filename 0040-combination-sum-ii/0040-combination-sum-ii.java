class Solution {

    private void recursion(int[] candidates, int indx, int target, List<List<Integer>> ans, List<Integer> temp){

        if (target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // is current index pe -> ek baar jo element le liya -> vohi element is same index pe dobara nahi lenge:
        for (int i = indx; i < candidates.length; i++){
            //  if (i > 0 && candidates[])
            if (i > indx && candidates[i] == candidates[i-1]) continue;
            if (candidates[i] > target) break;
            temp.add(candidates[i]);
            recursion(candidates, i+1, target-candidates[i], ans, temp);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);

        recursion(candidates, 0, target, ans, temp);

        return ans;
    }
}