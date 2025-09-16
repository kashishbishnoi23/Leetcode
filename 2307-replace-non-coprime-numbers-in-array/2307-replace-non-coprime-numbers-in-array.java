class Solution {

      // Compute GCD using Euclid's algorithm
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Compute LCM using GCD
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b; // safe long computation
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Long> stack = new Stack<>();
        
        for (int num : nums) {
            long cur = num; // cast int to long

            // Merge repeatedly with stack top until co-prime
            while (!stack.isEmpty() && gcd(stack.peek(), cur) > 1) {
                cur = lcm(stack.pop(), cur);
            }

            stack.push(cur);
        }

        // Convert stack to List<Integer> safely
        List<Integer> ans = new ArrayList<>();
        for (long x : stack) {
            ans.add((int)x); // safe because final values <= 10^8
        }

        return ans;
    


        // return ans;


    }
}