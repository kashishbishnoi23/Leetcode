class Solution {

    private final int[][] directions = {
       {1, 3},
       {0,2,4},
       {1,5},
       {0,4},
       {3,5,1},
       {4,2}
    };
    public int slidingPuzzle(int[][] board) {
        
        StringBuilder startState = new StringBuilder();
        // ham board ki state ko string me store krayenge -> ham zero se start krenge aur zero ko alag alag jagah swap krte rahenge, once we get "123450"  we will stop

        for (int i = 0; i < 2; i++){
        for (int j = 0; j < 3; j++){
            startState.append(board[i][j]);
          }
        }

        Map<String, Integer> visited = new HashMap<>();
        // will store ki is state tak pahuchne me kitne steps lage -> last me we'll return visited.get("12350")

        dfs(startState.toString(), visited, startState.indexOf("0"), 0);

        return visited.getOrDefault("123450", -1);
        
    }

    private void dfs(String state, Map<String, Integer> visited, int zeroPos, int moves){

    // skip if this state has already been visited with fewer or equal moves:
    if (visited.containsKey(state) && visited.get(state) <= moves){
    return;
    }

    visited.put(state, moves);

    // Try moving zero to each possible adjacent position:
    for (int nextPos : directions[zeroPos]){
       String newState = swap(state, zeroPos, nextPos);

       dfs(newState, visited, nextPos, moves+1);
    }


    }

    private String swap(String str, int i, int j){
       StringBuilder sb = new StringBuilder(str);

       sb.setCharAt(i, str.charAt(j));
       sb.setCharAt(j, str.charAt(i));
       return sb.toString();

    }
}