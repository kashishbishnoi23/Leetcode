class Solution {

    class Node{
        String str;
        int level;

        public Node(String str, int level){
            this.str = str;
            this.level = level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        Set<String> done = new HashSet<>();
    

        for (String word : wordList) st.add(word);
            if (!st.contains(endWord)) return 0;

        
        // start with beginWord:
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(beginWord, 0));
        done.add(beginWord);

        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++){
                Node front = q.poll();
                String str = front.str;
                int level = front.level;
                if (str.equals(endWord)) return level+1;
                 

                for(int j = 0; j < str.length(); j++){
                    StringBuilder sb = new StringBuilder(str);
                    for (char ch = 'a'; ch <= 'z'; ch++){
                        sb.setCharAt(j, ch);
                        if (st.contains(sb.toString()) && !done.contains(sb.toString())){
                            q.offer(new Node(sb.toString(), level+1));
                            done.add(sb.toString());
                        }
                    }
                }
            }
        }

        return 0;

    }
}