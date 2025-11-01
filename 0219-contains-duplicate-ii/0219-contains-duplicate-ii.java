class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // store the indices:
        HashMap<Integer, Integer> hashing = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (hashing.containsKey(nums[i])){
                if (i - hashing.get(nums[i]) <= k) return true;
            }
            hashing.put(nums[i], i);
        }

        return false;


    }
}