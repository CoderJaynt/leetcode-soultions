class Solution {
    public int helper(int[] nums, int k){
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;

        int cnt = 0;

        while(r < n){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.size() > k){
                int freq = map.get(nums[l]);

                if(freq == 1){
                    map.remove(nums[l]);
                }else{
                    map.put(nums[l], freq - 1);
                }

                l++;
            }

            cnt += (r-l+1);
            r++;
        }

        return cnt;
    }
    
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
}