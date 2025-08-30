class Solution {
    // class Pair{
    //     int value;
    //     int freq;
    //     public Pair(int value, int freq){
    //         this.value = value;
    //         this.freq = freq;
    //     }
    // }
    
  Map<Integer, Integer> memo = new HashMap<>();

private int recursive(int index, int[] points) {
    if (index >= points.length) return 0;
    if (memo.containsKey(index)) return memo.get(index);

    int take = points[index] + recursive(index + 2, points);
    int skip = recursive(index + 1, points);

    int ans = Math.max(take, skip);
    memo.put(index, ans);
    return ans;
}

    public int deleteAndEarn(int[] nums) {
        int max = 0;
    for (int num : nums) max = Math.max(max, num);

    int[] points = new int[max + 1];
    for (int num : nums) points[num] += num;

    memo.clear();
    return recursive(0, points);

























        // PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
        //     if (a.freq != b.freq){
        //         return Integer.compare(b.freq, a.freq);
        //     }

        //     return Integer.compare(b.value, a.value);
        // });

        // HashMap<Integer, Pair> hashing = new HashMap<>();

        // for (int i = 0; i < n; i++){
        //     //    hashing.set(nums[i], hashing.getOrDefault(nums[i], 0)+1); 
        //     Pair p;
        //     if (hashing.containsKey(nums[i])){
        //         p = hashing.get(nums[i]);
        //         p.freq++;
        //     } else{
        //         p = new Pair(nums[i], 1);
        //         hashing.put(nums[i], p);
        //     }
        // }

        // for (int key : hashing.keySet()){
        //     pq.offer(hashing.get(key));
        // }

        // int points = 0;
        
        // while(!pq.isEmpty()){
        //     Pair p = pq.poll();
        //     int value = p.value;
        //     int freq = p.freq;

        //     points += value;
        //     p.freq--;

        //     if (p.freq > 0){
        //         pq.offer(p);
        //     }
            
        //     Pair first, second;
        //     // access the x-1 and x+1:
        //     if (hashing.containsKey(value-1)){
        //         first = hashing.get(value-1);
        //         pq.remove(first);
        //         hashing.remove(first);
        //     }

        //     if (hashing.containsKey(value+1)){
        //         second = hashing.get(value+1);
        //         pq.remove(second);
        //         hashing.remove(second);
        //     }

        //     System.out.println("points = " + points);



        // }

        // return points;
       
    }
}