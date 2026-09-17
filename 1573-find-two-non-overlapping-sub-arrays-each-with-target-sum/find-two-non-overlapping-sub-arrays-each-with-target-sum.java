class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        int INF = 1_000_000_000;
        
        // Initialize DP array with infinity
        for (int i = 0; i < n; i++) {
            dp[i] = INF;
        }
        
        int left = 0;
        int sum = 0;
        int minLen = INF;
        int ans = INF;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
            // Shrink window if sum exceeds target
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }
            
            // Target found
            if (sum == target) {
                int currLen = right - left + 1;
                
                // Check if a valid subarray exists before the current left index
                if (left > 0 && dp[left - 1] != INF) {
                    ans = Math.min(ans, currLen + dp[left - 1]);
                }
                
                minLen = Math.min(minLen, currLen);
            }
            
            // Store the minimum length of valid subarray ending at or before 'right'
            dp[right] = minLen;
        }
        
        return ans >= INF ? -1 : ans;
    }
}