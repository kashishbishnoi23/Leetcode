class Solution {

    private int[] overlap(int[] arr1, int[] arr2){
         if (arr2[0] >= arr1[0] && arr2[0] <= arr1[1]){
             return new int [] {arr1[0], Math.max(arr1[1], arr2[1])};
         } else {
            return new int []{-1, -1};
         }
    }
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
        Integer.compare(a[0], b[0]));

        for (int [] interval : intervals){
            pq.offer(interval);
        }

        ArrayList<int[]> ans = new ArrayList<>();

        while(!pq.isEmpty()){
            int [] current = pq.poll();
            System.out.println(current[0] + " " + current[1]);

            if (pq.isEmpty()){
                ans.add(current);
                break;
            }

            // jab tak overlap ho kraate jao:
                int [] top = pq.peek();
                int [] over = overlap(current, top);

                if (over[0] == -1 && over[1] == -1){
                    ans.add(current);
                } else {
                    pq.poll();
                    pq.offer(over);
                }
            
        }

        return ans.toArray(new int [ans.size()][]);



    }
}