class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

                
        // land first:

        // minimum start time + duration:
        int min1 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++){
            min1 = Math.min(min1, landStartTime[i] + landDuration[i]);
        }

        int min2 = Integer.MAX_VALUE;

        // minimum waiting + duration:
        for (int j = 0; j < m; j++){
            int waiting = (waterStartTime[j] <= min1) ? 0 : waterStartTime[j] - min1;
            min2 = Math.min(min2, waiting+waterDuration[j]);
        }
        int first = min1 + min2;

        min1 = Integer.MAX_VALUE;
        min2 = Integer.MAX_VALUE;

        // take water first:
        for (int i = 0; i < m; i++){
            min1 = Math.min(min1, waterStartTime[i] + waterDuration[i]);
        }

        // minimum waiting + duration:
        for (int j = 0; j < n; j++){
            int waiting = (landStartTime[j] <= min1) ? 0 : landStartTime[j] - min1;
            min2 = Math.min(min2, waiting+landDuration[j]);
        }

        int second = min1 + min2;

        return Math.min(first, second);

        







        
    }
}