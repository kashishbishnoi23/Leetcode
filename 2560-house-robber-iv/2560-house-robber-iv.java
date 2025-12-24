class Solution {

    private boolean canPick(int[] nums, int k, int cap) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= cap) {
                count++;
                i += 2; // skip adjacent
            } else {
                i++;
            }
        }
        return count >= k;
    }

    public int minCapability(int[] nums, int k) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;

        for (int x : nums) {
            left = Math.min(left, x);
            right = Math.max(right, x);
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPick(nums, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
