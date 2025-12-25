class Solution {

    static final int MOD = 1000000007;
    HashMap<String,Integer> hashing = new HashMap<>();

    private int recursion(int curr, int startPos, int endPos, int steps){

        if (steps < 0) return 0;

        if ( steps < Math.abs(curr - endPos)) return 0;

        if (steps == 0){
            if (curr == endPos) return 1;
            return 0;
        }

        String key = curr + " " + steps;
        if (hashing.containsKey(key)) return hashing.get(key);

        // go left:
        long left = recursion(curr-1, startPos,  endPos, steps-1);

        // go right:
        long right = recursion(curr+1, startPos, endPos,steps-1);
        int ans = (int)((left + right) % MOD);

        hashing.put(key, ans);

        return ans;
        
        
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        int diff = endPos - startPos;
        return recursion(startPos, startPos, endPos, k);
    }
}