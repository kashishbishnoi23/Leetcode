class Solution {
    
    int maxDist;
    int farthestNode;

    private void dfs(ArrayList<ArrayList<Integer>> adjList, int dist, int parent, int node){

        if (dist > maxDist){
            maxDist = dist;
            farthestNode = node;
        }

        for (int nei : adjList.get(node)){
            if (parent == nei) continue;
            dfs(adjList, dist+1, node, nei);
        }
    }

    private int findDiameter(int n, int [][] edges){
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 1; i <= n+1; i++){
            adjList.add(new ArrayList<>());
        }

        for (int [] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        maxDist = -1;
        dfs(adjList, 0, -1, 0);
        int farthest = farthestNode;

        // second dfs from farthest:
        maxDist = -1;
        dfs(adjList, 0, -1, farthest);

        return maxDist; // this is the diameter


    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length;
        int d1 = findDiameter(n, edges1);
         
        int m = edges2.length;
        int d2 = findDiameter(m, edges2);

        int combined = (d1+1)/2 + 1 + (d2+1)/2;

        return Math.max(d1,  Math.max(d2, combined));
        
    }
}