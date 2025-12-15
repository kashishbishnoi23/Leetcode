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
        

        Integer[][] distances = new Integer[n][n];

        for (int i = 0; i < n; i++){
            distances[i][i] = 0;
        }

        for (int[] edge : edges){
           int a = edge[0];
           int b = edge[1];
           int w = edge[2];
           distances[a][b] = w;
           distances[b][a] = w;

         
        }

        // I have to reach from city a to city b within a distance of distanceThreshold , maybe floyd warshall?? find all the minimum distances

    
        for (int k = 0; k < n; k++){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                   if (distances[i][k] != null && distances[k][j] != null){
                    int newd = distances[i][k] + distances[k][j];
                    if (distances[i][j] == null || distances[i][j] > newd){
                        distances[i][j] = newd;
                    }

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
                if (distances[i][j] != null && distances[i][j] <= distanceThreshold){
                    count++;
                }
            }

            pq.offer(new Node(i, count));
        }

        return pq.poll().node;




    }
}