class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;

        int[] even = new int[n+1];
        int[] odd = new int[n+1];
        even[0] = 0;
        odd[0] = 0;

        int e = 0;
        for(int i=0 ; i<n ; i++){
            if(nums[i]%2 == 0){
                e++;
                even[i+1] = e;
            }else{
                even[i+1] = e;
            }
        }

        int o = 0;
        for(int i = 0 ; i<n ; i++){
            if(nums[i]%2 == 1){
                o++;
                odd[i+1] = o;
            }else{
                odd[i+1] = o;
            }
        }

        int ans = 0;

        for(int i = 0 ; i<n ; i++){
            for(int j = i ; j<n ; j++){
                int even_no = even[j+1] - even[i];
                int odd_no = odd[j+1] - odd[i];

                if(odd_no == 0){
                    continue;
                }

                if(1L * even_no * b <= 1L * odd_no * a){
                    ans++;
                }
            }
        }

        return ans;
    }
}