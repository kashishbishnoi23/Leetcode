class Solution {
    public int[] singleNumber(int[] nums) {
         int xor = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++){
            xor ^= nums[i];
        }

        // create two groups based on the first different bit:
        int position = -1;
        // find the first different bit:
        for (int i = 0; i < 32; i++){
            if ((xor & (1 << i)) != 0){
                position = i;
                break;
            }
        }
        int a = 0;
        int b = 0;

        // create two groups:
        for (int i = 0; i < n; i++){
            // if the different bit is 0, push to a
            if ((nums[i] & (1 << position)) == 0){
                 a ^= nums[i];
            } else {
                // else push to group b
                b ^= nums[i];
            }
        }

        return new int[] {a, b};
    }
}