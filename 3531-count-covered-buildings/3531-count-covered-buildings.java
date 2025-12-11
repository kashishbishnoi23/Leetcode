class Solution {
    
    private boolean smaller(ArrayList<Integer> arr,int val){

        // smaller:
        int start = 0;
        int end = arr.size()-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if (arr.get(mid) < val) return true;

            end = mid-1;
            
        }

        return false;

    }

    private boolean larger(ArrayList<Integer> arr, int val){

        int start = 0;
        int end = arr.size()-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if (arr.get(mid) > val) return true;

            start = mid + 1;
        }

        return false;
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        // int[][] matrix = new int[n+1][n+1];

        // for (int[] building : buildings){
        //     int i = building[0];
        //     int j = building[1];
        //     matrix[i][j] = 1;
        // }
         
        // int count = 0;
        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < n; j++){
        //         if (isCovered(i, j, matrix)){
        //             count ++;
        //         }
        //     }
        // }

        // return count;

        HashMap<Integer, ArrayList<Integer>> rowhash = new HashMap<>();

        HashMap<Integer, ArrayList<Integer>> colhash = new HashMap<>();

        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];

            if (!rowhash.containsKey(x)){
                rowhash.put(x, new ArrayList<>());
            }

            if (!colhash.containsKey(y)){
                colhash.put(y, new ArrayList<>());
            }

            rowhash.get(x).add(y);
            colhash.get(y).add(x);
        }

        for(int key : rowhash.keySet()){
            Collections.sort(rowhash.get(key));
        }

        for (int key : colhash.keySet()){
            Collections.sort(colhash.get(key));
        }

        int count = 0;

        for (int[] building : buildings){
            int row = building[0];
            int col = building[1];
            
            // check all the four directions:
            
            // first in rowhash, check if there is a col smaller and larger then col in row key:
            ArrayList<Integer> arr = rowhash.get(row);
            boolean flag1 = smaller(arr, col);
            if (!flag1) continue;
            boolean flag2 = larger(arr, col);
            if (!flag2) continue;
            
            ArrayList<Integer> arr2 = colhash.get(col);
            boolean flag3 = smaller(arr2, row);
            if (!flag3) continue;

            boolean flag4  = larger(arr2, row);
            if (!flag4) continue;
             
             count ++;



        }

        return count;



       




    }
}