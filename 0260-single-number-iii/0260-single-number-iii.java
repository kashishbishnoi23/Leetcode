class Solution {
    public int[] singleNumber(int[] nums) {
        // so basically, I have to find the first position where the bit differs , so one of them has bit 0 and the other has bit 1 , so now divide all the elements into 2 groups , one group has 1 at that position and other has 0, so a and b will go into 2 different groups , now xor of each group will give us numbers cuz the pairs will be cancelled out

        int size = nums.length;
        int xor = 0;
        for (int num : nums){
            xor ^= num;
        }

        // find the first set bit from right:
        // int i = xor & (-xor);  will not work for larger numbers:
        int i = 0;
        for (int k = 0; k < 32; k++){
            if (((1 << k) & xor) != 0){
                i = k;
                break;
            }
        }

        // form 2 groups a and b:
        int a = 0;
        int b = 0;

        for (int num : nums){
            // check the ith bit of num:
            if ((num & (1 << i)) != 0){
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};

    }
}