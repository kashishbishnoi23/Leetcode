class Solution {

    static class Node{
        int val;
        int count;

        public Node(int val, int count){
            this.val = val;
            this.count = 1; 
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // store the integer with their node:
        HashMap<Integer, Node> hashing = new HashMap<>();

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));

        for (int i = 0; i < n; i++){
            int val = nums[i];
            Node node = null;
            if (!hashing.containsKey(val)){
                node = new Node(val, 1);
                hashing.put(val, node);
            } else {
                hashing.get(val).count ++;
            }
        }

        for (int key : hashing.keySet()){
            pq.offer(hashing.get(key));
        }

        int count = 0;
        int[] ans = new int[k];
        int indx = 0;
        System.out.println(pq.size());

        while(count < k){
            ans[indx++] = pq.poll().val;
            count ++;
        }

        return ans;
        
    }
}