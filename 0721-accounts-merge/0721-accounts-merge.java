class Solution {

    static class DSU{
        
        int N;
        int[] parent;
        int[] size;

        public DSU(int n){
            this.N = n;
            this.parent = new int[n];

            for (int i = 0; i < n; i++){
                parent[i] = i;
            }

            this.size = new int[n];
        }

        private int findPar(int node){
            if (parent[node] == node) return node;
            return parent[node] = findPar(parent[node]);
        }



        private void union(int i, int j){
            int par1 = findPar(i);
            int par2 = findPar(j);

            if (par1 == par2) return;

            if (size[par1] >= size[par2]){
                parent[par2] = par1;
            } else {
                parent[par1] = par2;
            }
        }


    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        // max nodes n ho sakte hain -> har node ek person ko denote krta hai

        DSU dsu = new DSU(n);

        // koi email common ha ya nahi => ye check krne k liye ham hashmap use krenge -> store email with its node
        HashMap<String, Integer> hashing = new HashMap<>();

        for(int i = 0; i < n; i++){
            for (int j = 1; j < accounts.get(i).size(); j++){
                // agar email already exist krti hai map me -> yani is shaks ka account already hai -> nodes ko merge kro -> j aur i ko
                String email = accounts.get(i).get(j);

                if (hashing.containsKey(email)){
                    int node1 = hashing.get(email);
                    int node2 = i;
                    dsu.union(node1, node2);
                } 

                hashing.put(email, i);

            }
        }

        List<List<String>> ans = new ArrayList<>();

        HashMap<Integer, ArrayList<String>> temp = new HashMap<>();

        for (String key : hashing.keySet()){
            String email = key;
            int index = dsu.findPar(hashing.get(key));
            if (!temp.containsKey(index)){
                temp.put(index, new ArrayList<>());
            }

            temp.get(index).add(email);
        }

        for (Integer index : temp.keySet()){
            String name = accounts.get(index).get(0);

            List<String> emails = temp.get(index);
            Collections.sort(emails);
            
            emails.add(0, name);
            ans.add(emails);
        }

        return ans;



    }
}