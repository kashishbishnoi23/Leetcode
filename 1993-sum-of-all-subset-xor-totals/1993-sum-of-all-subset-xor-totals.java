class Solution {
    public int subsetXORSum(int[] nums) {
        // generate all the subsets and add their sum:
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < Math.pow(2, n); i++){
            int xor = 0;
            for (int j = 0; j < n; j++){
                if (((1 << j) & i) != 0){
                    xor ^= nums[j];
                }
            }
            sum += xor;
        }

        return sum;


    }
}