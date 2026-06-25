class Solution {
    
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {        
        
        int n = prices.length;

        dp = new int[n+1][2][k+1];

        for(int idx = n-1 ; idx>=0 ; idx--){
            for(int buy = 0 ; buy<=1 ; buy++){
                for(int t = 1 ; t<=k ; t++){

                    if(buy == 1){
                        dp[idx][buy][t] = Math.max(-prices[idx] + dp[idx+1][0][t], dp[idx+1][1][t]);
                    }else{
                        dp[idx][buy][t] = Math.max(prices[idx] + dp[idx+1][1][t-1], dp[idx+1][0][t]);
                    }

                }
            }
        }        

        return dp[0][1][k];
    }

}