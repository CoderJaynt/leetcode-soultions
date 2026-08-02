class Solution {
    Integer[][] dp;
    public int helper(int l, int r, int[] piles){
        if(l == r){
            return piles[l];
        }

        if(dp[l][r] != null){
            return dp[l][r];
        }

        int left = piles[l] - helper(l+1, r, piles);
        int right = piles[r] - helper(l, r-1, piles);

        return dp[l][r] = Math.max(left, right);
    }
    public boolean stoneGame(int[] piles) {
        dp = new Integer[piles.length][piles.length];
        return helper(0, piles.length-1, piles) > 0;
    }
}