class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxLight = 0;

        for(int x : lights){
            maxLight = Math.max(maxLight, x);
        }

        int ans = 0;

        for(int x : arrivalTime){
            int r = x % period;

            int waiting;

            if(r < maxLight){
                waiting = 0;
            }else{
                waiting = period - r;
            }

            ans = Math.max(ans, waiting);
        }

        return ans;
    }
}