/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// class Pair{
//     TreeNode node;
//     int index;
//     int row;

//     Pair(TreeNode node, int index, int row){
//         this.node = node;
//         this.index = index;
//         this.row = row;
//     }
// }



class Pair{
    TreeNode node;
    int horizontal;
    int vertical;
    public Pair(TreeNode node,int horizontal, int vertical){
        this.node = node;
        this.horizontal = horizontal;
        this.vertical = vertical;
    }
};
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
    
        // List<List<Integer>> ans = new ArrayList<>();
        // if (root == null) return ans;

        // Queue<Pair> q = new LinkedList<>();
        // Map<Integer, Map<Integer, ArrayList<Integer>>> hashing = new TreeMap<>();

        // q.add(new Pair(root,0,0));

        // while(!q.isEmpty()){
        //     int size = q.size();

        //     for (int i = 0; i < size; i++){
        //         Pair front = q.poll();
        //         TreeNode node = front.node;
        //         int index = front.index;
        //         int row = front.row;

        //         if (hashing.containsKey(index)){
        //             // check if the same row exists or not:
        //             Map<Integer, ArrayList<Integer>> map = hashing.get(index);
        //             // ArrayList<Integer> list = new ArrayList<>();

        //        ArrayList<Integer> list = map.getOrDefault(row, new      ArrayList<>());
        //        list.add(node.val);
        //        Collections.sort(list);
        //        map.put(row, list);

                    
        //     } else {
        //             Map<Integer, ArrayList<Integer>> temp = new TreeMap<>();
        //             ArrayList<Integer> list = new ArrayList<>();
        //             list.add(node.val);
        //             temp.put(row, list);
        //             hashing.put(index, temp);
        //         }

        //         if (node.left != null){
        //             q.add(new Pair(node.left, index-1, row+1));
        //         }

        //         if (node.right != null){
        //             q.add(new Pair(node.right, index+1, row+1));
        //         }

        //     }
        // }

        // for (Map<Integer, ArrayList<Integer>> map : hashing.values()){
        //     ArrayList<Integer> lst = new ArrayList<>();

        //     for (ArrayList<Integer> st: map.values()){
        //         for (int val : st){
        //             lst.add(val);
        //         }
        //     }

        //     ans.add(lst);

        // }

        // return ans;


     
     List<List<Integer>> lst = new ArrayList<>();

    Map<Integer, Map<Integer,List<Integer>>>hashing = new TreeMap<>();

     Queue<Pair> queue = new LinkedList<>();
     queue.add(new Pair(root, 0, 0));

     while(!queue.isEmpty()){
        int size = queue.size();

        for (int i = 0; i < size; i++){
            Pair p = queue.poll();
            TreeNode node = p.node;
            int horizontal = p.horizontal;
            int vertical = p.vertical;

            if (hashing.get(vertical) == null){
                hashing.put(vertical, new TreeMap<>());
            }

            if (hashing.get(vertical).get(horizontal) == null){
                hashing.get(vertical).put(horizontal, new ArrayList<>());
            }

            hashing.get(vertical).get(horizontal).add(node.val);

            if (node.left != null){
                queue.add(new Pair(node.left, horizontal+1, vertical-1));
            }

            if (node.right != null){
                queue.add(new Pair(node.right, horizontal+1, vertical+1));
            }
            
        }
     }

    for (int key : hashing.keySet()){
        List<Integer> temp = new ArrayList<>();
        for (int innerKey : hashing.get(key).keySet()){
            List<Integer> value = hashing.get(key).get(innerKey);
            Collections.sort(value);
            for (int val : value){
                temp.add(val);
            }
        }
        lst.add(temp);
    }

     return lst;







    }
}