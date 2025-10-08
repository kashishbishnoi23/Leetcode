class MyHashSet {


    int [] data = new int [1000001];
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        data[key] = 1;
    }
    
    public void remove(int key) {
        data[key] = 0;
    }
    
    public boolean contains(int key) {
        if (data[key] == 1) return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */