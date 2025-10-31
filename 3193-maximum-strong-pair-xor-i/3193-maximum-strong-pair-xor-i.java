class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;

        for (int i = 0; i < n; i++){
            int curr = nums[i];
            for (int j = i+1; j < n; j++){
                int next = nums[j];
                int diff = Math.abs(curr-next);

                if (diff > curr) break;    

                max = Math.max(max, curr^next);    
                

            }
        }

        return max;
    }
}