class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;

        int[] prefixSum = new int [n];

        prefixSum[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int[] suffixSum = new int [n];

        suffixSum[n-1] = nums[n-1];

        for (int j = n-2; j >= 0; j--){
            suffixSum[j] = suffixSum[j+1] + nums[j];
        }

        int count = 0;
        for (int i = 0; i < n-1; i++){
            int diff = Math.abs(prefixSum[i] - suffixSum[i+1]);
            if (diff % 2 == 0) count++;
        }

        return count;
    }
}