class Solution{
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long total = 0; // Total distinct non-empty subsequences so far
        long[] end = new long[26]; // Count of subsequences ending at each char

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            
            // New subsequences created ending with c
            long newlyAdded = (total + 1 - end[idx] + MOD) % MOD;
            
            // Update total and end[idx]
            total = (total + newlyAdded) % MOD;
            end[idx] = (end[idx] + newlyAdded) % MOD;
        }

        return (int) total;
    }
}