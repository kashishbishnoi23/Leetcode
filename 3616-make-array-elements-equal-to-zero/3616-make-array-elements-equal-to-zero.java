class Solution {

    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        leftSum[0] = nums[0];

        for (int i = 1; i < n; i++){
            leftSum[i] += nums[i] + leftSum[i-1];
        }

        rightSum[n-1] = nums[n-1];

        for (int j = n-2; j >= 0; j--){
            rightSum[j] = nums[j] + rightSum[j+1];
        }

        for (int i = 0; i < n; i++){
            if (nums[i] == 0){
                // go to left
                if (leftSum[i] == rightSum[i]  || leftSum[i] == rightSum[i] + 1){
                    count ++;
                }


                // go to right
                if (rightSum[i] == leftSum[i] || rightSum[i] == leftSum[i] + 1){
                    count++;
                }
            }
        }



        
        return count;
    }
}