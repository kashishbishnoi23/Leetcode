class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int q = queries.length;
        int [] ans = new int[q];
        int indx = 0;

        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int query : queries){
            pq.offer(query);
        }

        HashMap<Integer, Integer> hashing = new HashMap<>();
        
        int j = 0;
        int sum = 0;
        while(!pq.isEmpty()){
            
        int req = pq.poll();
           while(j < n && sum + nums[j] <= req){
               sum += nums[j];
               j++;
           }

           hashing.put(req, j);

        }

        for (int query : queries){
            ans[indx++] = hashing.get(query);
        }

        return ans;






    }
}