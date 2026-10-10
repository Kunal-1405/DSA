class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalK = (long) k1 + k2;
        
        int[] diff = new int[n];
        long sumDiff = 0;
        int maxDiff = 0;
        
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sumDiff += diff[i];
            if (diff[i] > maxDiff) {
                maxDiff = diff[i];
            }
        }
        
        // If total operations can reduce all differences to 0
        if (sumDiff <= totalK) {
            return 0;
        }
        
        // Binary search for the optimal maximum difference cap
        long low = 0, high = maxDiff, target = maxDiff;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long opsNeeded = 0;
            for (int d : diff) {
                if (d > mid) {
                    opsNeeded += (d - mid);
                }
            }
            if (opsNeeded <= totalK) {
                target = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        // Apply the cap and track remaining operations
        long remainingK = totalK;
        long[] reducedDiff = new long[n];
        for (int i = 0; i < n; i++) {
            if (diff[i] > target) {
                remainingK -= (diff[i] - target);
                reducedDiff[i] = target;
            } else {
                reducedDiff[i] = diff[i];
            }
        }
        
        // Distribute any remaining operations greedily on elements equal to target
        for (int i = 0; i < n && remainingK > 0; i++) {
            if (reducedDiff[i] == target && target > 0) {
                reducedDiff[i]--;
                remainingK--;
            }
        }
        
        // Calculate final sum of squared differences
        long ans = 0;
        for (long d : reducedDiff) {
            ans += d * d;
        }
        
        return ans;
    }
}