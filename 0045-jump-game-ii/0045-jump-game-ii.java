class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int maxi  = 0;
        int jump = 0;
        int cur = 0;

        for(int i = 0 ; i<n-1 ; i++){
            maxi = Math.max(maxi, i+nums[i]);

            if(i == cur){
                jump++;
                cur = maxi;
            }
        }

        return jump;

    }
}