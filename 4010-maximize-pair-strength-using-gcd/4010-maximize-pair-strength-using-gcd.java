class Solution {
    public long gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public long maxPairStrength(int[] nums) {
        long ans = 0;

        for(int i = 0 ; i<nums.length ; i++){
            for(int j = i+1 ; j<nums.length; j++){
                long g = gcd(nums[i], nums[j]);

                long strn = 1L * g * g;

                ans = Math.max(ans, ((1L *nums[i]*nums[j])/strn));
            }
        }

        return ans;
    }
}