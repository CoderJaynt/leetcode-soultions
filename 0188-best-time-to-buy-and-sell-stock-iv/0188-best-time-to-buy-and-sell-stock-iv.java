class Solution {
    
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {        
        
        int n = prices.length;

        dp = new int[n][2][k+1];

        for(int[][] x: dp){
            for(int[] a: x){
                Arrays.fill(a, -1);
            }
        }

        return helper(0, k, 1, prices);
    }

    public int helper(int idx, int k, int buy, int[] prices){
        if(idx == prices.length) return 0;

        if(k == 0) return 0;

        if(dp[idx][buy][k] != -1) return dp[idx][buy][k];

        if(buy == 1){
            dp[idx][buy][k] = Math.max(-prices[idx] + helper(idx+1, k, 0, prices), helper(idx+1, k, 1, prices));
        }else{
            dp[idx][buy][k] = Math.max(prices[idx] + helper(idx+1, k-1, 1, prices), helper(idx+1, k, 0, prices));
        }

        return dp[idx][buy][k];
    }
}