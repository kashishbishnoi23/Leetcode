class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums){
            if (num != 0) list.add(num);
        }
        
        int index = 0;
        for (int i = 0; i < n; i++){
            nums[i] = (index < list.size()) ? list.get(index) : 0;
            index++;
        }

        
    }
}