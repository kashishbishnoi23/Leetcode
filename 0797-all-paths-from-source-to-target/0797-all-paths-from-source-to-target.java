class Solution {

    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, List<List<Integer>> ans, ArrayList<Integer> temp){
        int n = adj.size();
         
        temp.add(node);

        
        if (node == n-1){
            ArrayList<Integer> arr = new ArrayList<>();
            // Collections.addAll(arr, temp);
            arr.addAll(temp);
            ans.add(arr);
            temp.remove(temp.size()-1);
            return;

        }



        for (int neigh : adj.get(node)){
            dfs(neigh, adj, ans, temp);
            
        }

        if (!temp.isEmpty()) temp.remove(temp.size()-1);




    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = graph.length;


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++){
            for (int node : graph[i]){
                adj.get(i).add(node);
            }
            
            System.out.println("i =" + i);
            for (int a : adj.get(i)){
                System.out.println(a);
            }
        }

        

        ArrayList<Integer> temp = new ArrayList<>();

        dfs(0,adj, ans, temp);

        return ans;
    }
}