class Solution {
    int[] dp;
    public int helper(int i, int[] arr, int k){
        if(i == arr.length) return 0;

        if(dp[i] != -1) return dp[i];

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxSum = 0;

        for(int j = i ; j<Math.min(i+k, arr.length) ; j++){
            len++;
            maxi = Math.max(maxi, arr[j]);

            int sum = (len*maxi) + helper(j+1, arr, k);

            maxSum = Math.max(sum, maxSum);
        }

        dp[i] = maxSum;

        return dp[i];
        
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return helper(0, arr, k);
    }
}