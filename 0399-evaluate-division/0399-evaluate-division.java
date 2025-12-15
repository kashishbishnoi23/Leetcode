class Solution {


    class Node{
        String node;
        double val;

        public Node(String node, double val){
            this.node = node;
            this.val = val;
        }
    }

    private double dfs(String start, String node, String end, HashMap<String, ArrayList<Node>> hashing,HashSet<String> visited){ 
        
        visited.add(node);

        if (node.equals(end)) return 1.0;

        if (hashing.containsKey(node)){
            for (Node neigh : hashing.get(node)){
                String str = neigh.node;
                if (visited.contains(str)) continue;
                visited.add(str);
                double val = neigh.val;

                   
                double next = val*dfs(start, str, end, hashing, visited);
                // System.out.println("next = " + next);
                if (next >= 0) return next;

            }
        }


        return -1.0;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // equations ko edges maan lo:
        HashMap<String, ArrayList<Node>> hashing = new HashMap<>();


        for (int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);

            String a = equation.get(0);
            String b = equation.get(1);

            if (!hashing.containsKey(a)){
                hashing.put(a, new ArrayList<>());
            }

            if (!hashing.containsKey(b)){
                hashing.put(b, new ArrayList<>());
            }  

            hashing.get(a).add(new Node(b, values[i]));
            hashing.get(b).add(new Node(a, 1/values[i]));

        }

        int n = queries.size();

        double[] ans = new double[n];

        for (int i = 0; i < n; i++){
            List<String> q = queries.get(i);
            String a = q.get(0);
            String b = q.get(1);
            HashSet<String> visited = new HashSet<>();
            double div = -1.0;

            if (hashing.containsKey(a) && hashing.containsKey(b)){
              div = dfs(a, a, b, hashing,visited);
            }

            ans[i] = div;
        }

        return ans;


    }
}