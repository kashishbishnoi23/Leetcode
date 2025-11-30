class Solution {


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int [n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        if (n == 1){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        return list;

        }

        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }


          for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);

            degree[a]++;
            degree[b]++;
          }


        Queue<Integer> queue = new LinkedList<>();


        // push all the leaves to queue:
        for (int i = 0; i < n; i++){
            if (degree[i] == 1){
                queue.offer(i);
            }
        }

        int remaining = n;


        while(!queue.isEmpty() && remaining > 2){
            int size = queue.size();

            for (int i = 0; i < size; i++){
                int front = queue.poll();
                remaining --;

                for (int a : adj.get(front)){
                    degree[a]--;

                    if (degree[a] == 1){
                        queue.offer(a);
                    }

                } 

            }
            if (remaining <= 2) break;   


        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            ans.add(queue.poll());
        }

        return ans;



          
    }
}