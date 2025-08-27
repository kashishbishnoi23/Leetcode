class Solution {

    class Pair{
        int u;
        int v;
        int sum;
        public Pair(int u, int v, int sum){
            this.u = u;
            this.v = v;
            this.sum = sum;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        List<List<Integer>> list = new ArrayList<>();


        // PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.sum - a.sum);

        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < m; j++){
        //         int sum = nums1[i] + nums2[j];
        //         if (pq.size() >= k){
        //             // pop out the one with more size:
        //             if (pq.peek().sum > sum){
        //                 pq.poll();
        //             } else {
        //                 continue;
        //             }
        //         }
        //         pq.add(new Pair(nums1[i], nums2[j], sum));
        //     }
        // }


        // while(k > 0){
        //     Pair p = pq.poll();
        //     list.add(new ArrayList<>(List.of(p.u, p.v)));
        //     k--;
        // }

        // return list;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.sum-b.sum);

        // push the starting points to the priority queue -> nums1[i], nums2[0]

        for (int i = 0; i < Math.min(k, n); i++){
            pq.offer(new Pair(i, 0, nums1[i]+nums2[0]));
        }
       
        while(k > 0){
            // pop out the minimum sum:
            Pair p = pq.poll();
            list.add(new ArrayList<>(List.of(nums1[p.u], nums2[p.v])));

            // now add if possible:
            if (p.v + 1 < m){
                pq.offer(new Pair(p.u, p.v+1, nums1[p.u] + nums2[p.v+1]));
            }

            k--;
        }

        return list;



    }
}