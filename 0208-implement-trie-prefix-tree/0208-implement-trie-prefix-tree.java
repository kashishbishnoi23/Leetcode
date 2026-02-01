class Trie {

    static class Node{
        Node[] arr; // length 26 -> denotes alphabets from 0 to 26
        boolean flag; // if flag is true -> a word ends here

        public Node(){
            this.flag = false;
            this.arr = new Node[26];
        }

    };

    Node root;

    public Trie() {
        root = new Node();   
    }
    
    public void insert(String word) {

        Node temp = root;
        
        for (char ch : word.toCharArray()){
            int indx = ch - 'a';
            if (temp.arr[indx] == null){
                // this curr indx is null:
                temp.arr[indx] = new Node();
            }
             
            temp = temp.arr[indx];

        }
        temp.flag = true;

    }
    
    public boolean search(String word) {
        Node temp = root;

        for (char ch : word.toCharArray()){
            int indx = ch - 'a';
            Node node = temp.arr[indx];
            if(node != null){
                temp = node;
            } else {
                return false;
            }
        }

        return temp.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;

        for (char ch : prefix.toCharArray()){
            int indx = ch - 'a';
            Node node = temp.arr[indx];

            if (node == null) return false;

            temp = node;
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */