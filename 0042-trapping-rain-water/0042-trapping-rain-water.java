class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] rightMax = new int[n];

        for (int i = n-1; i >= 0; i--){
            rightMax[i] = (i == n-1) ? height[i] : Math.max(height[i], rightMax[i+1]);
        }

        int leftMax = 0;
        int water = 0;

        for (int j = 0; j < height.length; j++){
            leftMax = Math.max(leftMax, height[j]);
            water += Math.abs(height[j] - Math.min(leftMax, rightMax[j]));
        }

        return water;
    }
}