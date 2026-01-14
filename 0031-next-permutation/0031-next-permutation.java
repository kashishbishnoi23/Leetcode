class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // peeche se start kro -> agar ascending jata jara hai -> stop where it breaks:

        // eg, 354321. ab last se start kru agar mai -> 21 -> 21 sabse bada number hai jo 2 aur 1 se banega -> can't make it more bigger
        // 321 -> cant make it bigger either
        // so we'll stop at first index - 3 

        int b_indx = -1;

        for (int j = n-2; j >= 0; j--){
            if (nums[j] < nums[j+1]){
                b_indx = j;
                break;
            }
        }

        // System.out.println("break index = " + b_indx);

        // break_indx se just badi digit dhundho:

        if (b_indx >= 0){
        for (int i = n-1; i > b_indx; i--){
            // System.out.println(nums[i] + " " + nums[b_indx]);
            if (nums[i] > nums[b_indx]){
                // swap with b_indx:
                int temp = nums[i];
                nums[i] = nums[b_indx];
                nums[b_indx] = temp;
                break;
            }
        }
        }

  

        // reverse the array from b_indx + 1 to n-1:
        int start = b_indx + 1;
        int end = n-1;

        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}