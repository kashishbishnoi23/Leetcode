class Solution {

    // static class Node{
    //     int col;
    //     Node next;
    //     public Node(int col){
    //         this.col = col;
    //         this.next = null;
    //     }
    // }
    public int numberOfBeams(String[] bank) {

        // ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

        // for (int i = 0; i < bank.length; i++){
        //     String a = bank[i];
        //     Node head = new Node(-1);
        //     Node temp = head;
        //     for (int j = 0; j < a.length(); j++){
        //         if (a.charAt(j) == '1'){
        //             temp.next = new Node(j);
        //             temp = temp.next;
        //         }
        //     }

        //     adjList[i] = head;
        // }

        // Queue<Node> queue = new LinkedList<>();

        // queue.offer(adjList[0]);
        
        // while(!queue.isEmpty()){
        //     int size = queue.size();
        //     Node head = queue.poll();
        //     if (size == 1) continue;
        //     head = head.next;
        //     for (int i = 0; i < size; i++){

        //     }
        // }


       int n = bank.length;
       ArrayList<Integer> list = new ArrayList<>();

       for (int i = 0; i < n; i++){
          String a = bank[i];
          int count = 0;

          for (int j = 0; j < a.length(); j++){
            if (a.charAt(j) == '1'){
                count ++;
            }
          }

          if (count == 0) continue;
          list.add(count);
       }

       int ans = 0;

       for (int i = 0; i < list.size()-1; i++){
           ans += list.get(i)*list.get(i+1);
       }

       return ans;



    }
}