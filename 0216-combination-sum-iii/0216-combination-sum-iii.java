class Solution {

    private void recursion(int num, List<Integer> temp, List<List<Integer>> ans, int k, int target){

        if (temp.size() == k){
            if (target == 0){
                List<Integer> arr = new ArrayList<>(temp);
                ans.add(arr);
                return;
            }
        }

        if (num > target || target < 0 || num > 9){
            return;
        }

     

        // pick not pick:
        temp.add(num);
        recursion(num+1, temp,  ans, k, target-num);

        if (!temp.isEmpty()){
            temp.remove(temp.size()-1);
        }

        recursion(num+1, temp, ans, k, target);

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        recursion(1, temp, ans, k, n);

        return ans;
    }
}