class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int a = 0;
        int l = lower;

        while(a < nums.length && nums[a] < lower){
            a++;
        }

        for(int i = lower ; i<=upper ; i++){
            while(a < nums.length && nums[a] < i){
                a++;
            }

            if(a < nums.length && nums[a] == i){
                if(l <= i-1){
                    ans.add(Arrays.asList(l, i-1));
                }

                a++;
                l = i+1;
            }
        }

        if(l <= upper){
            ans.add(Arrays.asList(l, upper));
        }

        return ans;
    }
}