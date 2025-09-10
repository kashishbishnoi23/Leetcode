class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // int smallest = Integer.MAX_VALUE;

        // for (int i = 0; i < n; i++){
        //      if (nums[i] > 0){
        //         smallest = Math.min(smallest, nums[i]);
        //      }
        // }

        // if (smallest != 1) return 1;
        // smallest = 2;

        // for (int i = 0; i < n; i++){
        //     boolean found = false;
        //      for (int j = 0; j < n; j++){
        //         if (nums[j] == smallest){
        //             smallest ++;
        //             found = true;
        //             break;
        //         }
        //      }
        //      if (!found) return smallest;
        // }

        // return smallest;

        // sort the array:
        Arrays.sort(nums);
        if (nums[0] > 1) return 1;
        int smallest = nums[0] > 0 ? Math.min(nums[0],Integer.MAX_VALUE) : Integer.MAX_VALUE;

        for (int i = 1; i < n; i++){
            if (nums[i] > 1 && nums[i-1] <= 0){
                return 1;
            }
            if (nums[i] > 0){
              smallest = Math.min(smallest, nums[i]);
            }
            if (nums[i] > nums[i-1]+1){
                if (nums[i-1]+1 <= 0) continue;
                return nums[i-1]+1;
            }
      
        
        }


        if (smallest != 1) return 1;



        return nums[n-1]+1;

    

        // int count = 0;
        // int sum = 0;

        // for (int i = 0; i < n; i++){
        //     if (nums[i] >= 0){
        //         if (nums[i] > 0)smallest = Math.min(smallest, nums[i]);
        //         count ++;
        //         sum += nums[i];
        //     }
        // }

        // if (smallest != 1) return 1;

        // int expected = (count*(count+1))/2;

        // return  Math.abs(sum-expected);
    }
}