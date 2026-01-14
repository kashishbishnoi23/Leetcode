class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;

        HashMap<Integer, Integer> hashing = new HashMap<>();
        int count = 0;
        hashing.put(0, 1);

        for (int i = 0; i < n; i++){
            sum += nums[i];
            if (hashing.containsKey(sum-k)){
                count += hashing.get(sum-k);
            }       
            hashing.merge(sum, 1, Integer::sum);

        }

        return count;
    }
}