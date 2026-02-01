class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 1; i < nums.length; i++){
            // pq.offer(nums[i]);
            int curr = nums[i];

            if (pq.size() == 2){
                if (curr < pq.peek()){
                    pq.poll();
                    pq.offer(curr);
                }
            }  else{
                pq.offer(curr);
            }

        }

        int cost = first;

        cost += pq.poll();
        cost += pq.poll();

        return cost;


    }
}