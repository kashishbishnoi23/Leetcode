class RandomizedSet {

    Set<Integer> st = new HashSet<>();
    ArrayList<Integer> array = new ArrayList<>();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        boolean ans = false;
        if (!st.contains(val)){
            ans = true;
        } else {
            return ans;
        }
        array.add(val);
        st.add(val);
        return ans;

    }
    
    public boolean remove(int val) {
        if (st.contains(val)){
            st.remove(val);
            array.remove(Integer.valueOf(val));

            return true;
        }

        return false;
    }
    
    public int getRandom() {
        int size = array.size();
        int random = (int)(Math.random() * size);

        return array.get(random);


    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */