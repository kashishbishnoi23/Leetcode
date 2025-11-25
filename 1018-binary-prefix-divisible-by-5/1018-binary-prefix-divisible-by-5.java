class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();

        int curr = 0;
        for (int i = 0; i < nums.length; i++){
           curr = (curr*2 + nums[i]) % 5;
           ans.add(curr % 5 == 0);
        }

        return ans;
    }
}