class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            int val = num % k;
            long[] nextDp = new long[k];

            // 1. Start a new subarray with the current element
            nextDp[val]++;

            // 2. Extend existing subarrays from previous index
            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int nextRem = (r * val) % k;
                    nextDp[nextRem] += dp[r];
                }
            }

            // 3. Update DP state and accumulate to result
            dp = nextDp;
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}