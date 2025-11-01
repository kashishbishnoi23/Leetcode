class Solution {

    private static class Node{
        int count;
        int left;
        int right;

        public Node(int count, int left, int right){
            this.count = count;
            this.left = left;
            this.right = right;
        }
    }
    public int findShortestSubArray(int[] nums) {
        // find the degree:
        HashMap<Integer, Node> hashing = new HashMap<>();
        int n = nums.length;
        int deg = 1;
        

        for (int i = 0; i < n; i++){
            int key = nums[i];
            if (hashing.containsKey(key)){
                hashing.get(key).count++;
                hashing.get(key).right = i;
                deg = Math.max(deg, hashing.get(key).count);
            } else {
                hashing.put(key, new Node(1, i, i));
            }
        }

        
        int ans = n;
        System.out.println(deg);

        

        for (int key : hashing.keySet()){

            Node node = hashing.get(key);
            int right = node.right;
            int left = node.left;



            if (node.count == deg){
                ans = Math.min(ans, right-left+1);
                // System.out.println("key = " + key);
                // System.out.println("right = " + right);
                // System.out.println("left = " + left);
                System.out.println(ans + " " + node.count);
            }

        }

        return ans;


        
    }
}