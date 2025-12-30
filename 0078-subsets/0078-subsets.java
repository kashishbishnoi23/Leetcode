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

        // List<Integer> temp = new ArrayList<>();

        // recursion(ans, temp, nums, 0);


        // pick, not pick ka ek aur tareeka , we have length n -> 2^n combinations -> yani 2^n total subsets banenge

        // run loop for each subset:
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++){
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < n; j++){
                 // j is the number of left shifts:
                 if (((1 << j) & i ) != 0){
                    temp.add(nums[j]);
                 }
            }

            ans.add(temp);
        }

        return ans;
    }
}