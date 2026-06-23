class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] parent = new int[n];

        int maxi = 0;
        int lastIdx = 0;

        for(int i = 0 ; i<nums.length ; i++){
            parent[i] = i;

            for(int prev = 0 ; prev<i ; prev++){
                if(nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]){
                    dp[i] = 1+dp[prev];
                    parent[i] = prev;
                }
            }

            if(dp[i] > maxi){
                maxi = dp[i];
                lastIdx = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(nums[lastIdx]);

        while(parent[lastIdx] != lastIdx){
            lastIdx = parent[lastIdx];
            ans.add(nums[lastIdx]);
        }

        Collections.reverse(ans);

        return ans;
    }
}