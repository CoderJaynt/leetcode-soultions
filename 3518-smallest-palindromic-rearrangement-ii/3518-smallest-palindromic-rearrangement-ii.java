class Solution {
    static final long LIMIT = 1_000_001L;

    public long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    long combination(int n, int r) {

        if (r > n)
            return 0;

        r = Math.min(r, n - r);

        long ans = 1;

        for (int i = 1; i <= r; i++) {

            long num = n - r + i;
            long den = i;

            long g = gcd(num, den);
            num /= g;
            den /= g;

            g = gcd(ans, den);
            ans /= g;
            den /= g;

            if (ans > LIMIT / num)
                return LIMIT;

            ans *= num;
            ans /= den;

            if (ans > LIMIT)
                return LIMIT;
        }

        return ans;
    }

    long countPermutation(int[] half) {

        int total = 0;

        for (int x : half)
            total += x;

        long ways = 1;
        int remaining = total;

        for (int x : half) {

            if (x == 0)
                continue;

            long choose = combination(remaining, x);

            if (ways > LIMIT / choose)
                return LIMIT;

            ways *= choose;

            if (ways > LIMIT)
                return LIMIT;

            remaining -= x;
        }

        return ways;
    }

    public String smallestPalindrome(String s, long k) {
        

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int[] half = new int[26];
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;

            if (freq[i] % 2 == 1) {
                mid = (char) ('a' + i);
            }
        }

        if (countPermutation(half) < k) {
            return "";
        }

        int leftHalf = 0;

        for (int x : half) {
            leftHalf += x;
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < leftHalf; pos++) {
            for (int i = 0; i < 26; i++) {
                if (half[i] == 0) {
                    continue;
                }

                half[i]--;

                long cnt = countPermutation(half);

                if (cnt >= k) {
                    left.append((char) ('a' + i));
                    break;
                } else {
                    k -= cnt;
                    half[i]++;
                }
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + ((mid == 0) ? "" : mid) + right;
    }
}