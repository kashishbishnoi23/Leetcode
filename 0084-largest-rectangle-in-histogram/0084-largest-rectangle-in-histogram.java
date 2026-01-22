class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++){
            int curr = (i < n) ? heights[i] : 0;

            while(!st.isEmpty() && curr < heights[st.peek()]){
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i-st.peek()-1;

                int area = height*width;
                maxArea = Math.max(area, maxArea);

            }
            st.push(i);
        }

        return maxArea;
    }
}