class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        HashMap<List<Integer>, Integer> ans = new HashMap<>();
        
        for (int i = 0; i < n; i++){
            HashSet<Integer> st = new HashSet<>();
            for (int j = i+1; j < n; j++){
                // store elements between i and j in the set to avoid duplicates in future
                int sum = nums[i] + nums[j];
                int req = -sum;

                if (st.contains(req)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(req);
                    Collections.sort(temp);
                    ans.put(temp, 0);
                }

                st.add(nums[j]);

            }
        }

        List<List<Integer>> a = new ArrayList<>();

        for(List<Integer> t : ans.keySet()){
            a.add(t);
        }

        return a;
    }
}