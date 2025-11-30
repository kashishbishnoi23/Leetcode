class Solution {

    private void dfs(String node, List<String> ans, HashMap<String, PriorityQueue<String>> adj){
        
        PriorityQueue<String>pq = adj.get(node);

        while(pq != null && !pq.isEmpty()){
            String next = pq.poll();
            // next pe jate jao:
            dfs(next, ans, adj);
        }

        // dead end aa gaya: add to the ans:
        ans.add(0, node);
    }    
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> strs : tickets){
            String first = strs.get(0);
            String second = strs.get(1);
            if (!adj.containsKey(first)){
                adj.put(first, new PriorityQueue<>());
            }

            adj.get(first).offer(second);
        }


        List<String> ans = new ArrayList<>();

        dfs("JFK", ans, adj);

        return ans;



    }
}