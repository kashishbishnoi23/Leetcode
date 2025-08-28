class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b,a));

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (pq.size() < k){
                pq.offer(matrix[i][j]);
                continue;
                }

                if (matrix[i][j] < pq.peek()){
                    pq.poll();
                    pq.offer(matrix[i][j]);
                }
            }
        }

        return pq.poll();
    }
}