class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int idx = -1;

        int minDist = Integer.MAX_VALUE;

        for(int i = 0 ; i<drones.length ; i++){
            int xi = drones[i][0];
            int yi = drones[i][1];
            int ri = drones[i][2];

            int val = Math.abs(xi - target[0]) + Math.abs(yi - target[1]);

            if(val <= ri && val < minDist){
                minDist = val;
                idx = i;
            }
        }

        return idx;
    }
}