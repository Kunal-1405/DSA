class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] minSuffix = new int[n];
        
        // Build suffix minimum array O(n)
        minSuffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(nums[i], minSuffix[i + 1]);
        }
        
        // Maintain prefix maximum and check stability O(n)
        int maxPrefix = nums[0];
        for (int i = 0; i < n; i++) {
            maxPrefix = Math.max(maxPrefix, nums[i]);
            if (maxPrefix - minSuffix[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}