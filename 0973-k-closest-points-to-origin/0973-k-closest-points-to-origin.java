class Solution {

    static class Node{
        int x;
        int y;
        double distance;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
            distance = Math.sqrt(x*x + y*y);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Double.compare(b.distance, a.distance));

        for (int[] point : points){
            Node node = new Node(point[0], point[1]);

            if (pq.size() < k){
                pq.offer(node);
            } else {
                if (node.distance < pq.peek().distance){
                    pq.poll();
                    pq.offer(node);
                }
            }
        }

        int[][] ans = new int[k][2];
        int indx = 0;

        while(!pq.isEmpty()){

            Node node = pq.poll();
            int[] temp = new int[2];
            temp[0] = node.x;
            temp[1] = node.y;
            ans[indx++] = temp; 

        }

        return ans;
    }
}