class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        return nCr(n + k - 1, 2 * k);
    }

    private int nCr(int n, int r) {
        if (r > n) return 0;
        
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        
        long numerator = fact[n];
        long denominator = (fact[r] * fact[n - r]) % MOD;
        
        return (int) ((numerator * modInverse(denominator)) % MOD);
    }

    private long modInverse(long n) {
        return power(n, MOD - 2);
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}