class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();

        int j = 0;
        while(j < n && asteroids[j] < 0){
           st.push(asteroids[j++]);
        }

        while(j < n){
            int curr = asteroids[j];

            if (curr > 0){
                // agar positive hai -> simply push to the stack
                st.push(curr);
                j++;
                continue;
            }

            // agar negative hai aur st.peek() se chhota hai -> collide hoke khatam ho jayega:
            if (!st.isEmpty() && Math.abs(curr) < st.peek()){
                j++;
                continue;
            }

            if (!st.isEmpty() && Math.abs(curr) == st.peek()){
                st.pop();
                j++;
                continue;
            }

            // keep destroying the positives:
            while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(curr)){
                st.pop();
            }

            // ab ya to stack empty ho chuka hai -> ya usme negative elements hai ya equal strength ka positive element hai
            if (st.isEmpty() || st.peek() < 0){
                st.push(curr);
            } else if (st.peek() == Math.abs(curr)){
                st.pop();
            }
            j++;

        }

        int[] ans = new int[st.size()];

        for (int i = ans.length-1; i >= 0; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}