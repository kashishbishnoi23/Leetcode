class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int [] interval : intervals){
            pq.offer(interval);
        }

        ArrayList<int[]> list = new ArrayList<>();

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            if (pq.isEmpty()){
                list.add(top);
                break;
            }

            int[] next = pq.poll();
            if (next[0] <= top[1]){
                int first = top[0];
                int second = next[1] > top[1] ? next[1] : top[1];

                pq.offer(new int[] {first, second});
            } else {
                list.add(top);
                pq.offer(next);
            }
        }

        int[][] ans = new int[list.size()][2];
        int indx = 0;
        for (int[] i : list){
            ans[indx++] = i;
        }
        return ans;
    }
}