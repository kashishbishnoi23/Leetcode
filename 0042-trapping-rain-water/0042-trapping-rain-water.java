class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int water = 0;

        // create a rightmax array:
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(rightMax[i]);
        }

        int leftMax = height[0];

        for (int i = 0; i < n; i++) {
            int curr = Math.min(leftMax, rightMax[i]);
            if (curr > height[i]) {
                water += curr - height[i];
            }
            leftMax = Math.max(leftMax, height[i]);
        }

        return water;
    }
}