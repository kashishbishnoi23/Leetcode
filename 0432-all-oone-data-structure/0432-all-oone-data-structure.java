class AllOne {

    // create a DLL node:
    class DLL{
        int key; 
        HashSet<String> set;
        DLL next;
        DLL prev;

        public DLL(int freq, DLL prev, DLL next){
            this.key = freq;
            this.set = new HashSet<>();
            this.prev = prev;
            this.next = next;
        }
    }

    // create a map -> each string has a key as DLL node in which the string is present:
        private HashMap<String, DLL> mpp; // string : node
        private DLL start, end;

    public AllOne() {
           mpp = new HashMap<>();
           start = new DLL(0, null, null);
           end = new DLL(Integer.MAX_VALUE, null, null);
           start.next = end;
           end.prev = start;
        
    }
    
    public void inc(String key) {
             
         if (!mpp.containsKey(key)){
            // key is seen for the first time:
            // check if a DLL node with frequency 1 exists
            if (start.next.key == 1){
                // append to the DLL node with 1 freq:
                start.next.set.add(key);
                mpp.put(key, start.next);
            } else {
                // create a node with freq 1:
                DLL insert = new DLL(1,start, start.next);
                insert.set.add(key);
                start.next.prev = insert;
                start.next = insert;
                mpp.put(key, insert);
            }
         } else {
            DLL node = mpp.get(key);
            // if a node with freq + 1 exists => push the string to that node
            if (node.next.key == node.key + 1){
                node.next.set.add(key);
                node.set.remove(key);
                mpp.put(key, node.next);
            } else{
                // create a new node with freq as freq +1
                DLL insert = new DLL(node.key+1, node, node.next);
                insert.set.add(key);
                node.set.remove(key);
                node.next.prev = insert;
                node.next = insert;
                mpp.put(key, insert);
            }

            // cleanup empty node:
            if (node.set.isEmpty()){
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
         }

        
    }
    
    public void dec(String key) {
        if (!mpp.containsKey(key)) return;

        DLL node = mpp.get(key);

        if (node.key == 1){
            // key disappears:
            node.set.remove(key);
            mpp.remove(key);
        } else if (node.prev.key == node.key -1){
            node.prev.set.add(key);
            node.set.remove(key);
            mpp.put(key, node.prev);
        } else {
            DLL insert = new DLL(node.key-1, node.prev, node);
            insert.set.add(key);
            node.set.remove(key);
            node.prev.next = insert;
            node.prev = insert;
            mpp.put(key, insert);
        }

        // clean up if bucket is empty:
        if (node.set.isEmpty()){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    
    public String getMaxKey() {
        String ret = "";
        if (end.prev == start){
            return ret;
        } else {
            DLL node = end.prev;
            HashSet<String> strs = node.set;
            for (String s : strs){
                ret = s;
                break;
            }

        }
        return ret;
    }
    
    public String getMinKey() {
        String ret = "";
        if (end.prev == start){
            return ret;
        } else {
            DLL node = start.next;
            HashSet<String> strs = node.set;
            for (String s : strs){
                ret = s;
                break;
            }

        }
        return ret;
        
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */