class Solution {
    int[][] dp;
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
            Arrays.fill(x, 0);
        }
        

        for(int i = arr.length-2 ; i>=1 ; i--){
            for(int j = 1 ; j<arr.length-1 ; j++){
                int ans = 0;
                

                for(int idx = i ; idx<=j ; idx++){
                    int cost = arr[i-1] * arr[idx] * arr[j+1] + dp[i][idx-1] + dp[idx+1][j];

                    ans = Math.max(ans, cost);
                }

                dp[i][j] = ans;
            }
        }

        return dp[1][arr.length-2];
    }
}