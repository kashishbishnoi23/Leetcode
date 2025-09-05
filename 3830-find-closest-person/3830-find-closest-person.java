class Solution {
    public int findClosest(int x, int y, int z) {
        // if (z > y) return 2;
        // if (z < x) return 1;

        if (Math.abs(z-x) == Math.abs(z-y)) return 0;

        if (Math.abs(z-x) < Math.abs(z-y)) return 1;
        return 2;
    }
}