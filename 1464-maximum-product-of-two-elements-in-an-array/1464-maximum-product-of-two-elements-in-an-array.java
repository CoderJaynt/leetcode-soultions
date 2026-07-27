class Solution {
    public int maxProduct(int[] nums) {
        int ans = 0;

        Arrays.sort(nums);

        int i = nums[nums.length-1];
        int j = nums[nums.length-2];

        return (i-1) * (j-1);
    }
}