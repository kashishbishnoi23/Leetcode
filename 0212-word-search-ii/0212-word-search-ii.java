class Solution {

    Trie trie = new Trie();


    static class Node{
        Node[] arr;
        boolean flag;
        public Node(){
            this.arr = new Node[26];
            this.flag = false;
        }
    };


    // trie create kro:
    static class Trie{

        Node root;

        public Trie(){
            this.root = new Node();
        }
        
        // insert
        public void insert(String word){
            Node temp = root;
            for (char ch : word.toCharArray()){
                int indx = ch - 'a';
                Node node = temp.arr[indx];

                if (node == null){
                    temp.arr[indx] = new Node();
                }

                temp = temp.arr[indx];
            }

            temp.flag = true;
        }


        // search 
        public boolean search(String word){

            Node temp = root;

            for(char ch : word.toCharArray()){
                int indx = ch - 'a';

                Node node = temp.arr[indx];

                if (node == null) return false;

                temp = node;
            }

            return temp.flag;

        }

        // startsWith

        public boolean startsWith(String prefix){
            Node temp = root;

            for (char ch : prefix.toCharArray()){
                int indx = ch - 'a';

                Node node = temp.arr[indx];

                if (node == null) return false;
                temp = node;
            }

            return true;
        }


    };


    private void recursion(int row, int col, char[][] board,List<String> ans, StringBuilder sb, int[][] visited){
        
        int n = board.length;
        int m = board[0].length;

        char curr = board[row][col];

        sb.append(curr);
        visited[row][col] = 1;

        if (!trie.startsWith(sb.toString())){
            sb.deleteCharAt(sb.length()-1);
            visited[row][col] = 0;
            return;
        }


        if (trie.search(sb.toString())){
            if (!ans.contains(sb.toString())){
                ans.add(new String(sb));
            }
        }

        //  go to all the four directions:
        int[][] dirs = {{0, 1},{1, 0}, {0, -1},{-1, 0}};

        for (int[] dir : dirs){
            int newrow = row + dir[0];
            int newcol = col + dir[1];

            if (newrow >= 0 &&  newrow < n && newcol >= 0 && newcol < m && visited[newrow][newcol] == 0){

                recursion(newrow, newcol, board, ans, sb, visited);
                
            }
        }

        visited[row][col] = 0;
        sb.deleteCharAt(sb.length()-1);

    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int n = board.length;
        int m = board[0].length;


        for (String word : words){
            trie.insert(word);
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                // char start = board[i][j];
                String start = "" + board[i][j];
                if (trie.startsWith(start) == true){
                    StringBuilder sb = new StringBuilder();
                    int[][] visited = new int[n][m];
                    recursion(i, j, board, ans, sb, visited);
                }
            }
        }


        return ans;


    }


}