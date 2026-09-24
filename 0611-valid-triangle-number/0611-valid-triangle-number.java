class Solution {
    public int binarySearch(int l, int r, int[] nums, int target){
        int k = -1;

        while(l <= r){
            int mid = l + (r-l) / 2;

            if(nums[mid] < target){
                k = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return k;
    }
    public int triangleNumber(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int cnt = 0;

        if(n < 3){
            return 0;
        }

        for(int i = 0 ; i<n ; i++){
            
            for(int j = i+1 ; j<n ; j++){
                int sum = nums[i] + nums[j];               

                int k = binarySearch(j+1, n-1, nums, sum);

                if(k != -1){
                    cnt += (k-j);
                }
            }
        }

        return cnt;
    }
}