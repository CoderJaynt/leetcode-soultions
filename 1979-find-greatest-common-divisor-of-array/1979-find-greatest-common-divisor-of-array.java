class Solution {
    public int findGCD(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int i = 0 ; i<nums.length ; i++){
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }

        int ans = 1;

        for(int i = 1 ; i<=mini; i++){
            if(mini % i == 0 && maxi % i == 0){
                ans = Math.max(ans, i);
            }
        }

        return ans;
    }
}