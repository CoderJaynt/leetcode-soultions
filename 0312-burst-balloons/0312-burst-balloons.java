class Solution {
    int[][] dp;
    public int helper(int i, int j, int[] arr){
        if(i > j) return 0;

        if(dp[i][j] !=  -1) return dp[i][j];

        int ans = Integer.MIN_VALUE;

        for(int idx = i ; idx<=j ; idx++){
            int cost = arr[i-1] * arr[idx] * arr[j+1] + helper(i, idx-1, arr) + helper(idx+1, j, arr);

            ans = Math.max(ans, cost);
        }

        dp[i][j] = ans;

        return dp[i][j];
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n+2];

        arr[0] = 1;
        arr[n+1] = 1;

        for(int i = 0 ; i<n ; i++){
            arr[i+1] = nums[i];
        }

        dp = new int[n+2][n+2];

        for(int[] x: dp){
            Arrays.fill(x, -1);
        }

        return helper(1, arr.length-2, arr);
    }
}