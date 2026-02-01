class Solution {
    public int minimumCost(int[] nums) {
        int first = nums[0];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < nums.length; i++){
            pq.offer(nums[i]);
        }

        int cost = first;

        cost += pq.poll();
        cost += pq.poll();

        return cost;


    }
}