class Solution {

    private long kadane(int[] nums) {
        long maxSoFar = nums[0];
        long current = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            maxSoFar = Math.max(maxSoFar, current);
        }

        return maxSoFar;
    }
    public long maxSubarraySum(int[] nums, int k) {
        // int n = nums.length;
        // int loops = n/k;
        // long max = Long.MIN_VALUE;

        // int size = 1;
        // int multiple = 1;
        // for (int i = 0; i < loops; i++){
        //     size = k*multiple;

        //     int left = 0;
        //     int right = 0;
        //     long sum = 0;

        //     while(right <= size-1){
        //         sum += nums[right++];
        //     }


        //     max = Math.max(max, sum);

        //     while(right < n){
        //         sum -= nums[left++];
        //         sum += nums[right++];
        //         max = Math.max(max, sum);
        //     }
        //     multiple++;
        // }

        // return max;
             int n = nums.length;
        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;
        long[] kSum = new long[k];
        for (int i = 0; i < k; i++) {
            kSum[i] = Long.MAX_VALUE / 2;
        }
        kSum[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum - kSum[i % k]);
            kSum[i % k] = Math.min(kSum[i % k], prefixSum);
        }
        return maxSum;
    
    }
}