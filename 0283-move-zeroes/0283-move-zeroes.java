class Solution {

    private void swap(int first, int second, int[] nums){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        // ArrayList<Integer> list = new ArrayList<>();

        // for (int num : nums){
        //     if (num != 0) list.add(num);
        // }
        
        // int index = 0;
        // for (int i = 0; i < n; i++){
        //     nums[i] = (index < list.size()) ? list.get(index) : 0;
        //     index++;
        // }
        int lastZero = -1;
        for (int i = 0; i < n; i++){
            if (lastZero == -1 && nums[i] == 0){
                lastZero = i;
                continue;
            }

            if (nums[i] != 0 && lastZero != -1){
                // swap and move lastZero:
                swap(lastZero, i, nums);

                while(lastZero <= i && nums[lastZero] != 0){
                    lastZero ++;
                }
            }
            
        }

        
    }
}