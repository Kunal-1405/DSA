class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // Quick check: if s is shorter than t, it's impossible
        if (m < n) return 0;

        // dp[j] represents ways to form t[0...j-1]
        double[] dp = new double[n + 1];
        dp[0] = 1; // Base case: 1 way to form an empty target string

        for (int i = 1; i <= m; i++) {
            char charS = s.charAt(i - 1);
            // Traverse backwards to use values from the previous iteration
            for (int j = n; j >= 1; j--) {
                if (charS == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return (int) dp[n];
    }
}