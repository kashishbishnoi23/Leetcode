class Solution {

    // class Pair{
    //     String str;
    //     int distance;

    //     Pair(String str, int distance){
    //         this.str = str;
    //         this.distance = distance;
    //     }
    // }

    class Pair{
        String str;
        int distance;
        public Pair(String str, int distance){
            this.str = str;
            this.distance = distance;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord))return 0;
        HashSet<String> set = new HashSet<>(wordList);

        // level order traversal 

        Queue<Pair> q = new LinkedList<>(); // store the strings at levels
        Set<String> st = new HashSet<>(); // to avoid going back to an already done string

        // start with beginWord:
        q.offer(new Pair(beginWord, 1));

        while(!q.isEmpty()){     

        int size = q.size();

        for (int i = 0; i < size; i++){
            Pair pair = q.poll();
            String str = pair.str;
            int distance = pair.distance;
            // System.out.println(str);
            // System.out.println(distance);

            if (str.equals(endWord)){
                return distance;
            }

            st.add(str);

            // go to the next word:
            
            for (int j = 0; j < str.toCharArray().length; j++){
               char [] temp = str.toCharArray();

               // change the ith letter with all a to z:
               for (char ch = 'a'; ch <= 'z'; ch++){
                 temp[j] = ch;
                 String newstr = new String(temp);
                 if (!st.contains(newstr) && set.contains(newstr)){
                        st.add(newstr);
                        q.offer(new Pair(newstr, distance+1));
                 }
               }

               
            }

            }
        }

        return 0;




     














        
        
        // Queue<Pair> q = new LinkedList<>();
        // Set<String> st = new HashSet<>(wordList);

        // if (!st.contains(endWord)){
        //     return 0;
        // }

        // if (st.contains(beginWord)){
        //     st.remove(beginWord);
        // }

        // q.add(new Pair(beginWord, 1));

        // while(!q.isEmpty()){
        //     Pair front = q.poll();
        //     String str = front.str;
        //     int distance = front.distance;

        //     // System.out.println("string = " + str);
        //     // System.out.println("distance = " + distance);

        //     if (str.equals(endWord)){
        //         return distance;
        //     }
            
        //     char[] chars = str.toCharArray();

        //     for (int i = 0; i < str.length(); i++){
        //         char[] temp = Arrays.copyOf(chars, chars.length);
        //         for (char alpha = 'a'; alpha <= 'z'; alpha++){
        //             // replace ith character:
        //             temp[i] = alpha;
        //             String check = new String(temp);
        //             // System.out.println(check);
        //             if (st.contains(check)){

        //                 st.remove(check);
        //                 q.add(new Pair(check, distance+1));
        //             }
        //         }
        //     }
         
        // }

        // return 0;
    }
}