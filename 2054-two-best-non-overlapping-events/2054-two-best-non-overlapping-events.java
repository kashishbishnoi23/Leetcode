class Solution {

    class Pair{
        int startTime;
        int endTime;
        int val;

        public Pair(int startTime, int endTime, int val){
            this.startTime = startTime;
            this.endTime = endTime;
            this.val = val;
        }
    }

    public int maxTwoEvents(int[][] events) {
      
      PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) ->  Integer.compare(a.endTime, b.endTime));


      Arrays.sort(events,(a, b) -> Integer.compare(a[0], b[0]));
      
      int ans = 0;
    // Pair bestSoFar = new Pair(0, 0, 0);
    int bestSoFar = 0;
      for (int[] event : events){
          int start = event[0];
          int end = event[1];
          int val = event[2];

          // current event ki start se pehle jitne bhi events hai (present in queue) -> pick the best one and pair it with current event (should be non-overlapping)

          // pq me sabse aage vo event hai jo sabse jaldi khatam hoga -> agar hamara current event us event se hi overlap hora hai matlab baaki sabse to overlap hoga hi -> so we cannot pair up this event with any earlier event so we'll simply push it to the pq

          // release all the non-overlapping events and pair up the best one with the current event:

          while(!pq.isEmpty() && pq.peek().endTime < start){
            bestSoFar = Math.max(bestSoFar, pq.poll().val);
          }

          ans = Math.max(ans, bestSoFar + val);

        //   ans = Math.max(as)

         pq.offer(new Pair(start, end, val));


          

         
      }

      return ans;


        
        

    }
}