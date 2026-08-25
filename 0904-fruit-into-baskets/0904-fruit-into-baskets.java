class Solution {
    public int totalFruit(int[] fruits) {
        int t1 = -1, t2 = -1, l1 = -1, l2 = -1, l = 0, r = 0;

        int maxLen = 0;

        int n = fruits.length;

        while(n>r){
            int f = fruits[r];

            if(f == t1){
                l1 = r;
            }else if(f == t2){
                l2 = r;
            }else if(t1 == -1){
                t1 = f;
                l1 = r;
            }else if(t2 == -1){
                t2 = f;
                l2 = r;
            }else{
                if(l2 > l1){
                    l = l1 +1;
                    l1 = r;
                    t1 = f;
                    
                }else{
                    l = l2+1;
                    l2 = r;
                    t2 = f;
                }
            }

            int len = r-l+1;

            maxLen = Math.max(maxLen, len);

            r++;
        }

        return maxLen;
    }
}