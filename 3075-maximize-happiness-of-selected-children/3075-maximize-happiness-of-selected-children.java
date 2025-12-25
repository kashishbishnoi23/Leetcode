class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int h : happiness){
            pq.offer(h);
        }
        
        int steps = 0;
        long ans = 0;
       for (int i = 0; i < k; i++){
          int selected = pq.poll();
          selected -= steps;
          selected = selected < 0 ? 0 : selected;
          ans += selected;

          steps ++;
       }

       return ans;




    }
}