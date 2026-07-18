class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0, r=0, maxLen = 0, type1 = -1, type2 = -1, last1 = -1, last2 = -1;

        int n = fruits.length;

        while(r<n){
            int f = fruits[r];

            if(f == type1){
                last1 = r;
            }else if(f == type2){
                last2 = r;
            }else if(type1 == -1){
                type1 = f;
                last1 = r;
            }else if(type2 == -1){
                type2 = f;
                last2 = r;
            }else{
                if(last1<last2){
                    l = last1+1;
                    last1 = r;
                    type1 = f;
                }else{
                    l = last2+1;
                    last2 = r;
                    type2 = f;
                }
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }
}