class Solution {
    public long countCommas(long n) {
        if(n < 1000){
            return 0;
        }

        long strt = 1000;
        long comma = 1;

        long ans = 0;

        while(strt <= n){
            long end = Math.min(n, strt * 1000 - 1);

            ans += ((end - strt + 1)*comma);

            strt *= 1000;
            comma++;
        }

        return ans;
    }
}