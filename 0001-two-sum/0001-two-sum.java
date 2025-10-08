class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        // Arrays.sort(nums);

        HashMap<Integer, Integer> hashing = new HashMap<>();

        for (int i = 0; i < n; i++){
            hashing.put(nums[i], i);
        }

        for (int j = 0; j < n; j++){
            int required = target-nums[j];
            if (hashing.containsKey(required) && hashing.get(required) != j){
                return new int []{j, hashing.get(required)};
            }
        }

        

        // while(left < right){
        //     int sum = nums[left] + nums[right];
        //     if (sum == target){
        //         return new int []{left, right};
        //     } 

        //     if (sum > target){
        //         right--;
        //     } else {
        //         left++;
        //     }
        // }

        return new int[]{-1, -1};  
    }
}