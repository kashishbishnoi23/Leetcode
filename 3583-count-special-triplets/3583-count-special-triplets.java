class Solution {

    int mod = (int) 1e9 + 7;

    public int specialTriplets(int[] nums) {
        int n = nums.length;

        // return recursion(0, 1, 2, nums);
        HashMap<Integer, Integer> CountHash = new HashMap<>();

        for (int i = 0; i < n; i++){
            CountHash.put(nums[i] , CountHash.getOrDefault(nums[i], 0) + 1);
        }

        HashMap<Integer, Integer> LeftCount = new HashMap<>();
        long count = 0;

        for (int i = 0; i < n; i++){
            int v = nums[i];
            int target = 2*v;

            int lcount = LeftCount.getOrDefault(target, 0);
            int rcount = CountHash.getOrDefault(target, 0) - lcount;
            if(v == 0) rcount --;

            count = (count + (long) lcount * rcount) % mod;


            LeftCount.put(v, LeftCount.getOrDefault(v, 0) + 1);
        }

        return (int)count;





    }
}