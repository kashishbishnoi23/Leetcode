class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[] ans = new int[2];

        // for (int i = 0; i < n; i++){
        //     int a = nums[i];
        //     int req = target-a;
        //     for (int j = i+1; j < n; j++){
        //         if (nums[j] == req){
        //             ans[0] = i;
        //             ans[1] = j;
        //             return ans;
        //         }
        //     }
        // }

        HashMap<Integer, Integer> hashing = new HashMap<>();

        for (int i = 0; i < n; i++){
            if (hashing.containsKey(target-nums[i])){
                ans[0] = i;
                ans[1] = hashing.get(target-nums[i]);
            }
            hashing.put(nums[i], i);
        }
        return ans;
    }
}