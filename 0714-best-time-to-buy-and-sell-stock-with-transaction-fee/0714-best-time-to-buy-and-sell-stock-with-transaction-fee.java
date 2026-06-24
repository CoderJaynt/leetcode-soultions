class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length+1][2];

        int n = prices.length;

        dp[n][0] = dp[n][1] = 0;

        for(int idx = n-1 ; idx>=0 ; idx--){
            for(int buy = 0 ; buy<=1 ; buy++){

                if(buy == 1){
                    dp[idx][buy] = Math.max(-prices[idx] - fee + dp[idx+1][0], dp[idx+1][1]);
                }else{
                    dp[idx][buy] = Math.max(prices[idx] + dp[idx+1][1], dp[idx+1][0]);
                }
            }
        }

        return dp[0][1];
    }
}