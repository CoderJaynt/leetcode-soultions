class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        Arrays.sort(nums);

        helper(0, nums, result, ds);    
        return result;
    }

    public void helper(int idx, int[] nums, List<List<Integer>> result, List<Integer> ds){
        result.add(new ArrayList<>(ds));

        for(int i = idx; i<nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]) continue;

            ds.add(nums[i]);
            helper(i+1, nums, result, ds);
            ds.remove(ds.size() - 1);
        }
    }
}