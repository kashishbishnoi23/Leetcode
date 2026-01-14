class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || n == 1) return;
        k %= n;
        int s = n-k;
        int e = n-1;

        int[] temp = new int[k];
        int indx = 0;
        while(s <= e){
            temp[indx++] = nums[s++];
        }

        for (int l = n-k-1; l >= 0; l--){
            nums[l+k] = nums[l];
        }

        for (int i = 0; i < k; i++){
            nums[i] = temp[i];
        }

     
    }
}