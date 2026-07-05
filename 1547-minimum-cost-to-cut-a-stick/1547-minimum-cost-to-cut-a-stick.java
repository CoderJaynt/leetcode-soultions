class Solution {
    int[][] dp;
    public int helper(int i, int j, int[] cuts){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;

        for(int idx = i ; idx<=j ; idx++){
            int cost = cuts[j+1] - cuts[i-1] + helper(i, idx-1, cuts) + helper(idx+1, j, cuts);

            mini = Math.min(mini,cost);
        }

        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        int[] newCuts = new int[m+2];

        newCuts[0] = 0;
        newCuts[m+1] = n;

        for(int i = 0 ; i<m ; i++){
            newCuts[i+1] = cuts[i];
        }

        Arrays.sort(newCuts);

        dp = new int[m+2][m+2];

        for(int[] x: dp){
            Arrays.fill(x, -1);
        }

        return helper(1, m, newCuts);
    }
}