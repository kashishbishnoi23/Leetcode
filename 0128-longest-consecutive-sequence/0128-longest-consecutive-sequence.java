class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Boolean> hashing = new HashMap<>();

        for (int num : nums){
            hashing.put(num, false);
        }

        int maxcount = 0;

        for (int i = 0; i < n; i++){
            if (hashing.containsKey(nums[i]-1) || !hashing.containsKey(nums[i])){
                continue;
            } else {
                // this is the start:         
                int count = 0;
                int number = nums[i];
                while(hashing.containsKey(number)){
                    // count this number and move to next
                    count ++;
                    hashing.remove(number);
                    number++;
                }
                maxcount = Math.max(maxcount, count);
            }


        }
        return maxcount;

    }
}