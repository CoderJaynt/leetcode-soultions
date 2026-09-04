class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i<nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int fre = nums.length/2;
        int ans = 0;

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() > fre){
                ans = m.getKey();
                break;
            }
        }

        return ans;
    }
}