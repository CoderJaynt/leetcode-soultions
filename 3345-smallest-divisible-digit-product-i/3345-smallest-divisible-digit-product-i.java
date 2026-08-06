class Solution {
    public int smallestNumber(int n, int t) {
        
        int ans = 1;
        for(int i = n ; i<=100 ; i++){
            int num = i;
            int digit = 1;

            while(num > 0){
                int last = num%10;
                num /= 10;

                digit *= last;
            }

            if(digit % t == 0){
                ans = i;
                break;
            }
        }

        return ans;
    }
}