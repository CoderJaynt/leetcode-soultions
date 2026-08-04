class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        int minx = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        for(int x: nums){
            set.add(x);
            minx = Math.min(minx, x);
            maxi = Math.max(maxi, x);
        }

        for(int i = minx ; i<=maxi ; i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }

        return ans;
    }
}