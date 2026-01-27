class Solution {

    private void recursive(int indx, int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp){

        if (target < 0 || indx == candidates.length) return;
          
          if (target == 0){
            List<Integer> arr = new ArrayList<>(temp);
            ans.add(arr);
            return;
          }
          // pick
          temp.add(candidates[indx]);
          recursive(indx, candidates, target-candidates[indx], ans, temp);
          if (temp.size() >= 1){
            temp.remove(temp.size()-1);
          }

          // not pick
          recursive(indx+1, candidates, target, ans, temp);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        recursive(0, candidates, target, ans, temp);

        return ans;


        


        // Time complexity -> O(2^(T/m + n)), where T is target, m is smallest number and n is totl number of elements -> let say m = 1, so depth becomes T and then -> not pick -> not pick -> and so on -> which adds n depth 
    }
}