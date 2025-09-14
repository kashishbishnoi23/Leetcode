class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        int size = nums.length;

        for (int i = 0; i < size; i++){
            xor ^= nums[i];
        }

        return xor;
    }
}