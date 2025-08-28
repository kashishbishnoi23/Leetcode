class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b- a);

        int n = stones.length;

        for (int i = 0; i < n; i++){
            pq.offer(stones[i]);
        }


        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            int remains = Math.abs(first - second);
            pq.offer(remains);
        }

        if (pq.isEmpty()) return 0;

        return pq.poll();

        


    }
}