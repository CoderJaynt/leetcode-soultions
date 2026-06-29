class Solution {
    int[][] dp;

    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];

        for(int[] x: dp){
            Arrays.fill(x, -1);
        }

        return helper(coins.length-1, amount, coins);
    }

    public int helper(int idx, int t, int[] coins){
        if(idx == 0){
            if(t % coins[0] == 0){
                return 1;
            }

            return 0;
        }

        if(dp[idx][t] != -1) return dp[idx][t];

        int notTake = helper(idx-1, t, coins);
        int take = 0;

        if(coins[idx] <= t){
            take = helper(idx, t - coins[idx], coins);
        }

        dp[idx][t] = take + notTake;

        return dp[idx][t];
    }
}