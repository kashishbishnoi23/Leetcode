class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int a : nums){
            pq.offer(a);
        }

        int count = 1;
        while(count < k){
            pq.poll();
            count ++;
        }

        return pq.poll();
    }
}