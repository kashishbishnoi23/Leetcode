class Solution {
    public int minimumDistance(int[] nums) {
         HashMap<Integer, ArrayList<Integer>> hashing = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++){
            if (!hashing.containsKey(nums[i])){
                hashing.put(nums[i], new ArrayList<>());
            }

            hashing.get(nums[i]).add(i);
        }

        int min = Integer.MAX_VALUE;
        for (int key : hashing.keySet()){
            if (hashing.get(key).size() < 3) continue;
            ArrayList<Integer> temp = hashing.get(key);
            int left = 0;
            int right = 2;
            while(right < temp.size()){
                int first = Math.abs(temp.get(left)-temp.get(left+1));
                int second = Math.abs(temp.get(left+1)-temp.get(right));
                int third = Math.abs(temp.get(right) - temp.get(left));
                min = Math.min(min, first+second+third);
                left++;
                right++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}