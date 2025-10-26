class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++){
            int curr = asteroids[i];
            if (st.isEmpty()){
                st.push(curr);
            } else {
                // agar st me positive h aur bahar negative h -> collision:
                while(!st.isEmpty() && st.peek() > 0 && curr < 0 && Math.abs(curr) > st.peek()){

                    st.pop();
                }

                if (!st.isEmpty() && st.peek() > 0  && curr < 0 && Math.abs(curr) <= st.peek()){
                    if (Math.abs(curr) == st.peek()){
                        st.pop();
                    }
                    continue;
                } 

                st.push(curr);
            }
        }

        int[] ans = new int[st.size()];

        for (int j = ans.length-1; j >= 0; j--){
            ans[j] = st.pop();
        }

        return ans;
    }
}