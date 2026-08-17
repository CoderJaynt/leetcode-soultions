class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;

        dp = new int[n];

        Arrays.fill(dp, -1);

        return helper(nums.length-1,  nums);
    }

    public int helper(int idx, int[] nums){
        if(idx < 0){
            return 0;
        }

        if(dp[idx] != -1) return dp[idx];

        int notTake = helper(idx-1, nums);

        int take = nums[idx] + helper(idx-2, nums);

        dp[idx] = Math.max(notTake, take);

        return dp[idx];
    }
}