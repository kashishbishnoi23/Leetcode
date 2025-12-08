class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int j = 0; j < n; j++){
            if (indegree[j] == 0){
                q.add(j);
            }
        }

        List<HashSet<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++){
            ans.add(new HashSet<>());
        }

        while(!q.isEmpty()){
            int front = q.poll();
            for (int neigh : adj.get(front)){
                indegree[neigh]--;

                for (int ances : ans.get(front)){
                    ans.get(neigh).add(ances);
                }
                ans.get(neigh).add(front);

                if (indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

        List<List<Integer>> orig = new ArrayList<>();

        for (int j = 0; j < n; j++){
            HashSet<Integer> st = ans.get(j);
            ArrayList<Integer> arr = new ArrayList<>();

            for (int s : st){
                arr.add(s);
            }
            Collections.sort(arr);
            orig.add(arr);
        }

        return orig;

        
    }
}