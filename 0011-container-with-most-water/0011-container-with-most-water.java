class Solution {
    public int maxArea(int[] height) {
        
        int max = 0;

        int n = height.length;
        int left = 0;
        int right = n-1;

        while(left < right){
            int width = right-left;
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, h*width);

            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}