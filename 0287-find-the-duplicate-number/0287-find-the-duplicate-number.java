class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> hashing = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++){
            if (hashing.containsKey(nums[i])) return nums[i];
            hashing.put(nums[i], 1);
        }

        return -1;
    }
}