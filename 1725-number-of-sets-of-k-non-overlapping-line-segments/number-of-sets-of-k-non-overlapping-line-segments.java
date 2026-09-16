class Solution {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        int totalPoints = n + k - 1;
        int r = 2 * k;

        // Compute C(totalPoints, r) % MOD in O(k) time
        long numerator = 1;
        long denominator = 1;

        for (int i = 1; i <= r; i++) {
            numerator = (numerator * (totalPoints - i + 1)) % MOD;
            denominator = (denominator * i) % MOD;
        }

        // Divide numerator by denominator using Modular Multiplicative Inverse
        return (int) ((numerator * modInverse(denominator, MOD)) % MOD);
    }

    private long modInverse(long a, long mod) {
        return power(a, mod - 2, mod);
    }

    private long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}