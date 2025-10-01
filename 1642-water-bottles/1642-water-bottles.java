class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;

        int empty = numBottles;

        while(empty >= numExchange){
            int drink = empty/numExchange;
            sum += drink;
            int remaining = empty % numExchange;
            empty = drink + remaining;         
        }
        return sum;
    }
}