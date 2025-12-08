class Solution {

    private boolean canMake(String recipe,
                             HashMap<String, HashSet<String>> hashing,
                             HashSet<String> supplies,
                             HashSet<String> visiting,
                             HashSet<String> memo) {

        if (supplies.contains(recipe)) return true;
        if (memo.contains(recipe)) return true;

        if (!hashing.containsKey(recipe)) return false;

        // cycle detected
        if (visiting.contains(recipe)) return false;

        visiting.add(recipe);

        for (String ing : hashing.get(recipe)) {
            if (!supplies.contains(ing)) {
                if (!canMake(ing, hashing, supplies, visiting, memo)) {
                    visiting.remove(recipe);
                    return false;
                }
            }
        }

        visiting.remove(recipe);

        // mark recipe as makeable
        memo.add(recipe);
        supplies.add(recipe);

        return true;
    }

    public List<String> findAllRecipes(String[] recipes,
                                      List<List<String>> ingredients,
                                      String[] supplies) {

        HashMap<String, HashSet<String>> hashing = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            HashSet<String> st = new HashSet<>(ingredients.get(i));
            hashing.put(recipes[i], st);
        }

        HashSet<String> suppset = new HashSet<>(Arrays.asList(supplies));
        HashSet<String> visiting = new HashSet<>();
        HashSet<String> memo = new HashSet<>();
        ArrayList<String> ans = new ArrayList<>();

        for (String r : recipes) {
            if (canMake(r, hashing, suppset, visiting, memo)) {
                ans.add(r);
            }
        }

        return ans;
    }
}
