class Solution {

    private int gcd(int a, int b){
        if (a < b){
            int temp = b;
            b = a;
            a = temp;
        }

        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    private int lcm(int x, int y){
        long lcm =  ((long) x*y)/gcd(x,y);
        return (int)lcm;
    }
    

    

    public List<Integer> replaceNonCoprimes(int[] nums) {
       Stack<Integer> st = new Stack<>();

       for (int num : nums){
        int curr = num;

        while(!st.isEmpty() && gcd(curr, st.peek()) > 1){
           curr = lcm(curr, st.pop());
        }

        
        st.push(curr); // if stack is empty or co-prime found
       }

       List<Integer> ans = new ArrayList<>();
       while(!st.isEmpty()){
           ans.add(st.pop());
       }
       Collections.reverse(ans);

       return ans;




    }
}