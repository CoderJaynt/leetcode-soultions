class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int maxi = 0;
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            maxi = Math.max(maxi, m.getValue());
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() == maxi){
                ans += m.getValue();
            }
        }

        return ans;
    }
}