class Solution {

  
    public int minJumps(int[] arr) {
        // dp is case me fail krega -> cuz cycles exist kr rhi hain -> infinite recursive calls -> Stack overflow

        // isliye ham bfs use krenge -> har index ko graph ka node maan lenge
        int n = arr.length;
        HashMap<Integer, ArrayList<Integer>> hashing = new HashMap<>();
        for (int i = 0; i < n; i++){
            if (!hashing.containsKey(arr[i])){
                hashing.put(arr[i], new ArrayList<>());
            }

            hashing.get(arr[i]).add(i);
        }

        int[] visited = new int[n];

        // start with 0 index:
        visited[0] = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                int indx = q.poll();
                if (indx == n-1) return level;

                // indx -1 
                if (indx - 1 >= 0 && visited[indx-1] == 0){
                    visited[indx-1] = 1;
                    q.offer(indx-1);
                }

                // indx + 1:
                if (indx + 1 < n && visited[indx+1] == 0){
                    visited[indx+1] = 1;
                    q.offer(indx+1);
                }

                // next :
                ArrayList<Integer> same = hashing.get(arr[indx]);

                 for (int next : same) {
                    if (visited[next] == 0) {
                        visited[next] = 1;
                        q.offer(next);
                    }
                }
                same.clear();

            }

            level++;
        }

        return -1;



    }
}