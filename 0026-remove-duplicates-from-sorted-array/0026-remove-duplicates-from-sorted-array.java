class Solution {
    public int removeDuplicates(int[] nums) {
         
        // using set :  TC : NlogN + N ,  SC = O(N)

        // Set<Integer>st = new TreeSet<>(); // logN for each operation 

        // for (int i = 0; i < nums.length; i++){
        //     st.add(nums[i]);
        // }
        
        // int j = 0;
        // for (int num : st){
        //      nums[j++] = num;
        // }

        // return st.size();

        // two pointer approach:

        // int size = nums.length;
    
        //  int i = 0;

        // for (int j = 1; j < size; j++){
             
        //      if (nums[j] > nums[i]){
        //         i++;
        //         nums[i] = nums[j];
        //      }

        // }

        // return i+1;



        // use a set:
        int n = nums.length;

        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums){
            set.add(num);
        }

        int i = 0;

        for (int num : set){
            nums[i++] = num;
        }

        return set.size();

    }
}