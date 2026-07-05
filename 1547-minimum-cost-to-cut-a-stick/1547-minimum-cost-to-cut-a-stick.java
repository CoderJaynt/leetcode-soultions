class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        int[] newCut = new int[m+2];

        newCut[0] = 0;
        newCut[m+1] = n;

        for(int i = 0 ; i<m ; i++){
            newCut[i+1] = cuts[i];
        }

        Arrays.sort(newCut);

        dp = new int[m+2][m+2];

        for(int i = m ; i>=1 ; i--){
            for(int j = i ; j<=m ; j++){
                int mini = Integer.MAX_VALUE;

                for(int idx = i ; idx<=j ; idx++){
            
                    int cost = newCut[j+1] - newCut[i-1] + dp[i][idx-1] + dp[idx+1][j];
            
                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }   
        

        return dp[1][m];
    }
}