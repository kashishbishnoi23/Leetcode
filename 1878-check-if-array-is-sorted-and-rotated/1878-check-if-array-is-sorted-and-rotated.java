class Solution {
    public boolean check(int[] nums) {
      
        // int size = nums.length;
        // boolean flag = false;

        // for (int i = 0; i < nums.length-1; i++){
        //     if (flag && nums[i] > nums[0]) return false;

            
        //     if (nums[i+1] < nums[i]){
        //         if (flag) return false;
        //         flag = true;
        //     }
          
        // }

        // if (flag && nums[size-1] > nums[0]) return false;

        // return true;

        int n = nums.length;
        int pivot = -1;
        boolean rotated = false;

        for (int i = 1; i < n; i++){
            if (!rotated && nums[i] >= nums[i-1]){
                continue;
            } else {
               pivot = i;
               // pivot should be smaller than first element:
               if (nums[pivot] > nums[0]){
                  return false;
               }
               if (rotated == false){
                  rotated = true;
                  if (nums[n-1] > nums[0]) return false;
                  continue;
               }

               if (!(nums[i] >= nums[i-1] && nums[i] <= nums[0])){
                    return false;
               }

            }
        }

        return true;



    }
}