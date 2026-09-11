class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0;
        int maxi = nums[0];       

        for(int i = 0 ; i<nums.length ; i++){
            

            if(curr < 0){
                curr = 0;
            }

            curr += nums[i];

            maxi = Math.max(maxi, curr);
        }


        return maxi;
    }
}