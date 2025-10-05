class Solution {
    class Node {
        int count;
        String str;

        public Node(String str, int count){
            this.count = count;
            this.str = str;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashing = new HashMap<>();
        int n = words.length;
        for (int i = 0; i < n; i++){
            hashing.merge(words[i], 1, Integer:: sum);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) ->{
            if (a.count != b.count){
                return Integer.compare(a.count, b.count);
            } 

            return b.str.compareTo(a.str);
        }
    );

    for (String key : hashing.keySet()){
        // System.out.println("key = " + key);
        if (pq.size() < k){
            pq.offer(new Node(key, hashing.get(key)));
        } else {
            // System.out.println("hello");
            int currCount = hashing.get(key);
            Node node = pq.peek();
            // System.out.println(node.str.compareTo(key));
            if (node.count < currCount || node.count == currCount && node.str.compareTo(key) > 0){
                // System.out.println(key);
                pq.poll();
                pq.offer(new Node(key, currCount));
            }
        }
    }

    List<String> ans = new ArrayList<>();

    while(!pq.isEmpty()){
        ans.add(pq.poll().str);
    }

    Collections.reverse(ans);

    return ans;



    }
}