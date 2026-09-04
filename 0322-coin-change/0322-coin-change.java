class Solution {
    int[][] dp;
    public int helper(int idx, int[] coins, int t){
        if(idx == 0){
            if(t % coins[0] == 0){
                return t/coins[idx];
            }

            return (int)1e9;
        }

        if(dp[idx][t] != -1) return dp[idx][t];

        int notTake = helper(idx-1, coins, t);

        int take = (int)1e9;

        if(coins[idx] <= t){
            take = 1 + helper(idx, coins, t - coins[idx]);
        }

        dp[idx][t] = Math.min(notTake, take);

        return dp[idx][t];
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];

        for(int[] x: dp){
            Arrays.fill(x, -1);
        }

        int ans = helper(coins.length-1, coins, amount);

        if(ans >= 1e9) return -1;

        return ans;
    }
}