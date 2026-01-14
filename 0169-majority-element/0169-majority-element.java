class Solution {
    public int majorityElement(int[] nums) {
        // moore's voting algorithm:
        int n = nums.length;
        int cnt = 0;
        int ele = -1;
        for (int i = 0; i < n; i++){
            if (cnt == 0){
                ele = nums[i];
                cnt++;
            } else {
                if (nums[i] == ele){
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }

        return ele;
    }
}