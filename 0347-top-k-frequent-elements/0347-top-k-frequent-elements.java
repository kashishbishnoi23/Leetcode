class Solution {
    static class Number{
        int num;
        int freq;

        public Number(int number, int freq){
            this.num = number;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int [] ans = new int [k];
        Map<Integer, Integer> hashing = new HashMap<>();

        // store the frequency of elements in the HashMap
        for (int num : nums){
            hashing.put(num, hashing.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Number> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.freq, b.freq));
        // Store the topmost k elements in The priority queue
        for (int key : hashing.keySet()){
            pq.offer(new Number(key, hashing.get(key)));
            if (pq.size() > k){
                pq.poll();
            }
        }

        int index = 0;

        // pop them out:
        while(k > 0){
           ans[index++] = pq.poll().num; 
           k--;
        }

        return ans;

    }
}