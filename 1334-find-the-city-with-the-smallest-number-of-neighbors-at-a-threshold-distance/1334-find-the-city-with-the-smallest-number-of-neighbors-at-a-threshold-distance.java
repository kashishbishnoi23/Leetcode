class Solution {


    class Node{
    int node;
    int cities;

    public Node(int node, int cities){
         this.node = node;
         this.cities = cities;
    }
   }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] dis = new int[n][n];

        // Arrays.fill(dis, 100000);
        for (int i = 0; i < n; i++){
            Arrays.fill(dis[i], 100000);
        }

        for (int[] edge : edges){
            dis[edge[0]][edge[1]] = edge[2];
            dis[edge[1]][edge[0]] = edge[2];

            dis[edge[0]][edge[0]] = 0;
            dis[edge[1]][edge[1]] = 0;
        }

        // go to each city using every k city:

        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    if (dis[i][k] + dis[k][j] < dis[i][j]){
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.cities != b.cities){
                return Integer.compare(a.cities, b.cities);
            }

            return Integer.compare(b.node, a.node);
        });


        for (int i = 0; i < n; i++){
            int count = 0;
            for (int j = 0; j < n; j++){
                if (dis[i][j] <= distanceThreshold){
                    count++;
                }
            }

            pq.offer(new Node(i, count));
        }

        return pq.poll().node;




    }
}