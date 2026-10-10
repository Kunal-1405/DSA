class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else { // s.charAt(i - 1) == ')'
                    int prevIndex = i - dp[i - 1] - 1;
                    if (prevIndex >= 0 && s.charAt(prevIndex) == '(') {
                        dp[i] = dp[i - 1] + 2 + (prevIndex >= 1 ? dp[prevIndex - 1] : 0);
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}